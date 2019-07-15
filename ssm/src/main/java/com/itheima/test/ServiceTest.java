package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {


    @Test
    public void run1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();
    }

}
