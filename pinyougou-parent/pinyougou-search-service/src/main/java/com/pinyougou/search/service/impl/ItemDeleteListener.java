package com.pinyougou.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Component
public class ItemDeleteListener implements MessageListener {
    @Autowired
    private ItemSearchService itemSearchService;
    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage=(ObjectMessage)message;
        try {
            Long[] goodsIds=(Long[])objectMessage.getObject();
            System.out.println("监听到消息"+goodsIds);
            itemSearchService.deleteByGoodsId(Arrays.asList(goodsIds));
            System.out.println("删除solr索引库数据");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
