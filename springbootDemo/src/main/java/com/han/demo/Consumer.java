package com.han.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {

    @JmsListener(destination = "itcast")
    public void readMessage(String text){
        System.out.println("监听到数据:"+text);
    }

    @JmsListener(destination = "itcast_map")
    public void readMessage(Map map){
        System.out.println("监听到数据:"+map);
    }

}
