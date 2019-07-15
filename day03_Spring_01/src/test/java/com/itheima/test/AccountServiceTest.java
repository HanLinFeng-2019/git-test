package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll(){
        //执行方法
        List<Account> accounts = as.findAll();
        for (Account account:accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        Account byId = as.findById(1);
        System.out.println(byId);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("张三");
        account.setMoney(500.0F);
        as.save(account);
    }

    @Test
    public void testDeleteById(){
        as.delete(13);
    }

    @Test
    public void testUpdate(){
        Account account = as.findById(12);
        account.setName("张三");
        as.update(account);
    }

}
