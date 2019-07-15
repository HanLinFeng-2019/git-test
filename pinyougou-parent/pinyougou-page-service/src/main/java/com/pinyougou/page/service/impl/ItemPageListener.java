package com.pinyougou.page.service.impl;

import com.pinyougou.page.service.ItemPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.io.Serializable;

@Component
public class ItemPageListener implements MessageListener {
    @Autowired
    private ItemPageService itemPageService;
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage=(TextMessage)message;
        try {
            String goodsId = textMessage.getText();
            System.out.println("监听到消息:"+goodsId);
            itemPageService.genItemHtml(Long.parseLong(goodsId));
            System.out.println("静态页面已经生成");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
