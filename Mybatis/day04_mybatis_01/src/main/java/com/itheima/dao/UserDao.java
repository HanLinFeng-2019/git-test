package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface UserDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @return
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveOne(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex} birthday=#{birthday} where id=#{id}")
    User UpdateTest(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    @Delete("delete from user where id=#{id}")
    void deleteTest(Integer userId);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findByIdTest(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
//    @Select("select * from user where username like #{username} ")
//    @Select("select * from user where username like '%${value}%' ")
    @Select("select * from usre where username like '%${value}%'")
    List<User> findUserByname(String username);

    /**
     * 查询总用户数量
     * @return
     */
//    @Select("select count(*) from user ")
    @Select("select count(*) from user")
    int findTotalUser();
}
