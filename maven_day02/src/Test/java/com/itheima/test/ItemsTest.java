package com.itheima.test;

import com.itheima.dao.ItemsDao;
import com.itheima.domain.Items;
import com.itheima.service.ItemsService;

import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ItemsTest {

    @Test
    public void testFindById(){
        ApplicationContext ca = new ClassPathXmlApplicationContext("applicationContext.xml");

        ItemsDao dao = ca.getBean(ItemsDao.class);
        Items items = dao.findById(1);
        System.out.println(items.getName());

    }
}
