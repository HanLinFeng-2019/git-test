package com.pinyougou.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 5000)
public class ItemSearchServiceImpl implements ItemSearchService {

    @Autowired
    private SolrTemplate solrTemplate;

    @Override
    public Map search(Map searchMap) {
        //关键字空格截取
        String keywords=(String)searchMap.get("keywords");
        searchMap.put("keywords",keywords.replace(" ",""));

        Map map=new HashMap();
        //1.查询列表(高亮)
       map.putAll(searchList(searchMap));
        //2.分组查询 商品分类列表
        List<String> categoryList = searchCategoryList(searchMap);
        map.put("categoryList",categoryList);
        //3.查询品牌和分类列表
        String categoryName = (String)searchMap.get("category");
        if(!"".equals(categoryName)){
            map.putAll(searchBrandAndSpecList(categoryName));
        }else{
            if(categoryList.size()>0){
                map.putAll(searchBrandAndSpecList(categoryList.get(0)));
            }
        }
        return map;
    }

    //查询列表高亮显示
    public Map searchList(Map searchMap){
        Map map=new HashMap();

        HighlightQuery query=new SimpleHighlightQuery();
        HighlightOptions highlightOptions=new HighlightOptions();
        //高亮参数设置
        highlightOptions.addField("item_title");//设置高亮域
        highlightOptions.setSimplePrefix("<em style='color:red'>");//前缀
        highlightOptions.setSimplePostfix("</em>");//后缀
        query.setHighlightOptions(highlightOptions);
        //1.1关键字查询
        Criteria criteria=new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        //1.2按商品分类过滤
        if(!"".equals(searchMap.get("category"))){
            FilterQuery filterQuery=new SimpleFilterQuery();
            Criteria filterCriteria=new Criteria("item_category").is(searchMap.get("category"));
            filterQuery.addCriteria(filterCriteria);
            query.addFilterQuery(filterQuery);
        }
        //1.3按商品品牌过滤
        if(!"".equals(searchMap.get("brand"))){
            FilterQuery filterQuery=new SimpleFilterQuery();
            Criteria filterCriteria=new Criteria("item_brand").is(searchMap.get("brand"));
            filterQuery.addCriteria(filterCriteria);
            query.addFilterQuery(filterQuery);
        }
        //1.4按规格过滤查询
        if(searchMap.get("spec")!=null){
        Map<String,String> specMap=(Map<String,String>)searchMap.get("spec");
        for(String key:specMap.keySet()){
            FilterQuery filterQuery=new SimpleFilterQuery();
            Criteria filterCriteria=new Criteria("item_spec_"+key).is(specMap.get("key"));
            filterQuery.addCriteria(filterCriteria);
            query.addFilterQuery(filterQuery);
            }
        }
        //1.5按价格区间过滤查询
        if(!"".equals(searchMap.get("price"))){
            String[] price = ((String) searchMap.get("price")).split("-");
            if(!price[0].equals("0")){//最低价格
                FilterQuery filterQuery=new SimpleFilterQuery();
                Criteria filterCriteria=new Criteria("item_price").greaterThanEqual(price[0]);
                filterQuery.addCriteria(filterCriteria);
                query.addFilterQuery(filterQuery);
            }
            if(!price[0].equals("*")){//最高价格
                FilterQuery filterQuery=new SimpleFilterQuery();
                Criteria filterCriteria=new Criteria("item_price").lessThanEqual(price[1]);
                filterQuery.addCriteria(filterCriteria);
                query.addFilterQuery(filterQuery);
            }
        }
        //1.6分页查询
        Integer pageNo = (Integer)searchMap.get("pageNo");//获取页码
        if(pageNo==null){
            pageNo=1;
        }
        Integer pageSize=(Integer)searchMap.get("pageSize");//获取页面大小
        if(pageSize==null){
            pageNo=20;
        }
        query.setOffset((pageNo-1)*pageSize);
        query.setRows(pageSize);
        //1.7查询商品排序
        String sortValue=(String)searchMap.get("sort");//升序ASC,降序DESC
        String sortField=(String)searchMap.get("sortField");//排序字段
        if(sortValue!=null && !sortValue.equals("")){
            if(sortValue.equals("ASC")){
                Sort sort=new Sort(Sort.Direction.ASC,"item_"+sortField);
                query.addSort(sort);
            }
            if(sortValue.equals("DESC")){
                Sort sort=new Sort(Sort.Direction.DESC,"item_"+sortField);
                query.addSort(sort);
            }
        }
        //获取高亮结果集
        HighlightPage<TbItem> page = solrTemplate.queryForHighlightPage(query, TbItem.class);
        List<HighlightEntry<TbItem>> entryList = page.getHighlighted();
        for(HighlightEntry<TbItem>  entry:entryList){
            List<HighlightEntry.Highlight> highlightList = entry.getHighlights();
//                for(HighlightEntry.Highlight h:highlightList){
//                    List<String> sns = h.getSnipplets();
//                    System.out.println(sns);
//                }
            if (highlightList.size()>0&& highlightList.get(0).getSnipplets().size()>0) {
                TbItem entity = entry.getEntity();
                entity.setTitle(highlightList.get(0).getSnipplets().get(0));
            }

        }
        map.put("rows",page.getContent());
        map.put("totalPages",page.getTotalPages());//给前端返回总页数
        map.put("total",page.getTotalElements());//给前端返回总记录数
        return map;
    }
    //分组查询
    public List<String> searchCategoryList(Map searchMap){
        List<String> list=new ArrayList<>();
        Query query=new SimpleQuery("*:*");
        //根据关键字查询
        Criteria criteria=new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        //设置分组选项
        GroupOptions groupOptions=new GroupOptions().addGroupByField("item_category");
        query.setGroupOptions(groupOptions);
        //获取分组页
        GroupPage<TbItem> page = solrTemplate.queryForGroupPage(query, TbItem.class);
        //获取分组页的结果对象
        GroupResult<TbItem> groupResult = page.getGroupResult("item_category");
        //分组页的入口对象
        Page<GroupEntry<TbItem>> groupEntries = groupResult.getGroupEntries();
        //分组页的入口集合
        List<GroupEntry<TbItem>> entryList = groupEntries.getContent();
        for(GroupEntry<TbItem> entry:entryList){
            list.add(entry.getGroupValue());//分组结果添加到返回值中
        }
        return list;
    }
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map searchBrandAndSpecList(String category){
        Map map=new HashMap();
        //1.根据商品名称得到模板Id
        Long templateId = (Long)redisTemplate.boundHashOps("itemCat").get(category);
        if(templateId!=null){
        //2.根据模板Id获得品牌列表
            List brandList = (List) redisTemplate.boundHashOps("brandList").get(templateId);
            map.put("brandList",brandList);
            //3.根据模板Id获取规格列表
            List specList = (List) redisTemplate.boundHashOps("specList").get(templateId);
            map.put("specList",specList);
        }

        return map;
    }

    @Override
    public void importList(List list) {

        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }
    @Override
    public void deleteByGoodsId(List goodsIdList){
        System.out.println("删除商品Id"+goodsIdList);
        Query query=new SimpleQuery();
        Criteria criteria = new Criteria("item_goodsid").in(goodsIdList);
        query.addCriteria(criteria);
        solrTemplate.delete(query);
        solrTemplate.commit();
    }

}
