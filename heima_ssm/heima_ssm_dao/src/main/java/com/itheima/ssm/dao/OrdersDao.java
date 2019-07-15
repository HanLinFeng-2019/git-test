package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersDao {

    /**
     * 查询所有订单
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id =true,property="id",column="id"),
            @Result(property="orderNum",column="orderNum"),
            @Result(property="orderTime",column="orderTime"),
            @Result(property="orderStatus",column="orderStatus"),
            @Result(property="peopleCount",column="peopleCount"),
            @Result(property="payType",column="payType"),
            @Result(property="orderDesc",column="orderDesc"),

            @Result(property="product",column="productId",javaType = Product.class,one = @One(select ="com.itheima.ssm.dao.ProductDao.findById")),
    })
    List<Orders> findAll();
}
