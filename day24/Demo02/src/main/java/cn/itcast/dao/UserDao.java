package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    /**
     * 用户添加方法
     * @param user
     */
    void add(User user);

    /**
     * 删除用户方法
     * @param id
     */
    void delete(int id);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User findUserById(int id);
}
