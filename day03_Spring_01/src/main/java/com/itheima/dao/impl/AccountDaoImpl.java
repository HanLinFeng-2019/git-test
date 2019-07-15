package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    private QueryRunner runner;
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    /**
     * 保存
     * @param account
     */
    public void save(Account account) {
        try {
            runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 修改
     * @param account
     */
    public void update(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除
     * @param accountId
     */
    public void delete(Integer accountId) {
        try {
            runner.update("delete from account where id=?",accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据Id删除
     * @param accountId
     */
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account where id=?", new BeanHandler<Account>(Account.class), accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll() {
        try {
            List<Account> list = runner.query("select * from account", new BeanListHandler<Account>(Account.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
