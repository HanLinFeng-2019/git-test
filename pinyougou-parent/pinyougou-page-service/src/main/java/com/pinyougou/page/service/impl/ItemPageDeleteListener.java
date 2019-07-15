package com.pinyougou.page.service.impl;

import com.pinyougou.page.service.ItemPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
public class ItemPageDeleteListener implements MessageListener {
    @Autowired
    private ItemPageService itemPageService;
    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage=(ObjectMessage)message;
        try {
            Long[] goodsIds = (Long[])objectMessage.getObject();
            System.out.println("监听到消息:"+goodsIds);
            itemPageService.deleteHtml(goodsIds);
            System.out.println("商品静态页面已经删除");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
