package com.han.test;


import com.han.demo.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-jms-producer.xml")
public class TestTopic {


    @Autowired
    private TopicProducer topicProducer;


    @Test
    public void testTopicSend(){
        topicProducer.sendTextMessage("我是发布订阅模式2号,你们收到了么!");
    }

}
