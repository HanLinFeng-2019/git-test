package com.itheima.test;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfiguration.class)
public class AccountServiceTest {
    ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("bean.xml");
    IAccountService as = ca.getBean("accountService",IAccountService.class);

    @Test
    public void testFindAll(){
//        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService as = ca.getBean("accountService",IAccountService.class);

        List<Account> accounts = as.findAllAccount();
        for (Account account:accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer(){


        as.transfer("aaa","bbb",100f);
    }
}
