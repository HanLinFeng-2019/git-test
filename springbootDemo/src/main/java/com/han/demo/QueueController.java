package com.han.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public void send(String text){
        jmsMessagingTemplate.convertAndSend("itcast", text);
    }

    @RequestMapping("/sendMap")
    public void sendMap(){
        Map map=new HashMap();
        map.put("张三",18);
        map.put("李四",20);

        jmsMessagingTemplate.convertAndSend("itcast_map", map);
    }

    @RequestMapping("/sendSms")
    public void sendSms(){
        Map map=new HashMap();
        map.put("mobile", "13900001111");
        map.put("template_code", "SMS_85735065");
        map.put("sign_name", "黑马");
        map.put("param", "{\"number\":\"102931\"}");
        jmsMessagingTemplate.convertAndSend("sms",map);
    }
}
