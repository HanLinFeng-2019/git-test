package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    //根据id查询产品
    @Select("select * from product where id=#{id}")
    Orders findById() throws Exception;

   //查询所有产品
    @Select("select * from product")
   List<Product> findAll() throws Exception;


     //新建保存产品
    @Insert("insert into product(productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

}
