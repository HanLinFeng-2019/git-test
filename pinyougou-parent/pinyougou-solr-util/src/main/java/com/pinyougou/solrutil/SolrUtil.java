package com.pinyougou.solrutil;

import com.alibaba.fastjson.JSON;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SolrUtil {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private SolrTemplate solrTemplate;

    public void importItemData(){
        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo("1");//审核通过商品

        List<TbItem> itemList = itemMapper.selectByExample(example);
        System.out.println("_______商品列表________");
        for(TbItem item:itemList){
            System.out.println(item.getTitle()+" "+item.getPrice()+" "+item.getBrand());
            Map map = JSON.parseObject(item.getSpec(), Map.class);//从数据库中取出规格json字符串数据,用转换成map格式的数据
            item.setSpecMap(map);
        }
        solrTemplate.saveBeans(itemList);
        solrTemplate.commit();
        System.out.println("____________结束_____________");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
        SolrUtil solrUtil = (SolrUtil) context.getBean("solrUtil");
        solrUtil.importItemData();
    }
}
