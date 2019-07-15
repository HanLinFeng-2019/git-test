package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户业务层的接口
 */
public interface IAccountService {

    void save(Account account);

    void update(Account accountId);

    void delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();
}
