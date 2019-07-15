package com.pinyougou.cart.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.pinyougou.cart.service.CartService;
import com.pinyougou.pojo.TbOrderItem;
import com.pinyougou.pojo.cart.Cart;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.CookieUtil;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Reference(timeout=6000)
    private CartService cartService;

    @RequestMapping("/findCartList")
    public List<Cart> findCartList(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        //从cookie中提取购物车
        String cartListString = CookieUtil.getCookieValue(request, "cartList", "UTF-8");
        if(cartListString==null||cartListString.equals("")){
            cartListString="[]";
        }
        List<Cart> cartList_cookie = JSON.parseArray(cartListString, Cart.class);

        if(username.equals("anonymousUser")){//未登录
            return cartList_cookie;
        }else{//如果已经登陆
            List<Cart> cartList_redis =cartService.findCartListFromRedis(username);//从redis中提取
            if(cartList_cookie.size()>0){//如果本地存在购物车
                //合并购物车
                cartList_redis=cartService.mergeCartList(cartList_redis, cartList_cookie);
                //清除本地cookie的数据
                util.CookieUtil.deleteCookie(request, response, "cartList");
                //将合并后的数据存入redis
                cartService.saveCartListToRedis(username, cartList_redis);
            }
            return cartList_redis;
        }

    }


    @RequestMapping("/add")
    @CrossOrigin(origins = "http://localhost:9105",allowCredentials = "true")//spring封装的跨域请求注解
    public Result addGoodsToCartList(Long itemId,Integer num){
//        response.setHeader("Access-Control-Allow-Origin","http://localhost:9105");//可以访问的域(此方法不需要操作cookie)
//        response.setHeader("Access-Control-Allow-Credentials","true");//跨域请求操作cookie
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);

        try {
            //从cookie中提取购物车
            List<Cart> cartList = findCartList();
            //调用服务方法操作购物车
            cartList = cartService.addGoodsToCartList(cartList, itemId, num);
            if(username.equals("anonymousUser")){//如果未登陆.保存到cookie中
                //将新的购物车存入cookie
                String cartListString = JSON.toJSONString(cartList);
                util.CookieUtil.setCookie(request,response,"cartList",cartListString,3600*2,"UTF-8");
                System.out.println("向cookie存入数据");
            }else{//如果已经登陆.保存到redis中
                cartService.saveCartListToRedis(username, cartList);
            }
            return new Result(true,"存入购物车成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"存入购物车失败");
        }
    }

}
