package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 登陆方法
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 添加用户方法
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除用户方法
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据ID查找绑定的用户
     * @param id
     * @return
     */
    User findUserById(String id);
}
