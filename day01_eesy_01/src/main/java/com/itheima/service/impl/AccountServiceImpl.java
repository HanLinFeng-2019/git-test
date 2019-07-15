package com.itheima.service.impl;

import com.itheima.Factory.BeanFactory;
import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {
//    private  AccountDao ad = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        int i=1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
