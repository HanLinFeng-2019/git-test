package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    /**
     * 保存
     * * @param account
     * */
    void save(Account account);

    /**
     *更新
     * @param account
     */
    void update(Account account);

    /**
     * 删除
     * @param accountId
     */
    void delete(Integer accountId);

    /**
     * 根据Id查询
     * @param accountId
     */
    Account findAccountById(Integer accountId);

    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();


}
