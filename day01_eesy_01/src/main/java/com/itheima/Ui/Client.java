package com.itheima.Ui;

import com.itheima.Factory.BeanFactory;
import com.itheima.service.AccountService;

/**
 * 模拟的表现层
 */

public class Client {
    public static void main(String[] args) {
//        AccountServiceImpl as = new AccountServiceImpl();


        for (int i = 0; i <5; i++) {
            AccountService as= (AccountService) BeanFactory.getBean("accountService");
           // as.saveAccount();
            System.out.println(as);
        }
    }
}
