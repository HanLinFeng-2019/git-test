package com.itheima.test;

import com.itheima.pojo.TbItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SolrDataQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_solr.xml")
public class TestTemplate {
    @Autowired
    private SolrTemplate solrTemplate;

    @Test
    public void TestAdd(){
        TbItem item=new TbItem();
        item.setId(1L);
        item.setTitle("华为Mate20Pro");
        item.setBrand("华为");
        item.setCategory("手机");
        item.setPrice(new BigDecimal(4999.00));
        item.setSeller("华为旗舰店");
        item.setGoodsId(10L);

        solrTemplate.saveBean(item);
        solrTemplate.commit();
    }
    @Test
    public void TestFindOne(){
        TbItem item = solrTemplate.getById(1L, TbItem.class);
        System.out.println(item.getTitle());
    }
    @Test
    public void TestDeleById(){
        solrTemplate.deleteById("1");
        solrTemplate.commit();
    }
    @Test
    public void TestAddList(){
        List list=new ArrayList();
        for(int i=0;i<100;i++){
            TbItem item=new TbItem();
            item.setId(i+1L);
            item.setTitle("华为Mate20Pro"+i);
            item.setBrand("华为"+i);
            item.setCategory("手机");
            item.setPrice(new BigDecimal(4999.00+i));
            item.setSeller("华为旗舰店");
            item.setGoodsId(10L);
            list.add(item);
        }
        solrTemplate.saveBeans(list);
        solrTemplate.commit();
    }
    @Test
    public void TestQueryPage(){
        //设置查询所有*:*
        Query query=new SimpleQuery("*:*");
        //条件查询
        Criteria criteria=new Criteria("item_category").contains("手机");
        criteria=criteria.and("item_brand").contains("2");
        query.addCriteria(criteria);

        //起始点
//        query.setOffset(20);
//        //每页几行记录数
//        query.setRows(5);

        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        for(TbItem item:page.getContent()){
            System.out.println(item.getTitle()+""+item.getPrice()+""+item.getBrand());
        }
        System.out.println("总记录数"+page.getTotalElements());
        System.out.println("总页数"+page.getTotalPages());
    }
    @Test
    public void TestDeleItem(){
        SolrDataQuery query=new SimpleQuery("*:*");
        solrTemplate.delete(query);
        solrTemplate.commit();
    }
}
