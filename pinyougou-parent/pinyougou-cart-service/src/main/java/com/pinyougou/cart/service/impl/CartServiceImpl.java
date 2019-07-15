package com.pinyougou.cart.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.cart.service.CartService;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbOrderItem;
import com.pinyougou.pojo.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private TbItemMapper itemMapper;
    @Override
    public List<Cart> addGoodsToCartList(List<Cart> cartList, Long itemId, Integer num) {
        //1.根据skuId查询商品SKU对象
        TbItem item = itemMapper.selectByPrimaryKey(itemId);
        if(item==null){
            throw new RuntimeException("商品不存在");
        }
        if(!item.getStatus().equals("1")){
            throw new RuntimeException("商品状态无效");
        }
        //2.根据SKU对象查询商家ID
        String sellerId = item.getSellerId();
        //3.根据商家ID在购物车列表中查询购物车对象

        Cart cart=searchCartBySellerId(cartList,sellerId);
        System.out.println(cart);

        //4.如果购物车中不存在该商家的购物车对象
        if(cart==null){
            //4.1创建一个新的购物车对象
            cart=new Cart();//新购物车对象
            cart.setSellerId(sellerId);//商家ID
            cart.setSellerName(item.getSeller());//商家名
            ArrayList<TbOrderItem> orderItemList = new ArrayList<>();//购物车明细列表
            TbOrderItem orderItem=createOrderItem(item,num);
            orderItemList.add(orderItem);//商品明细 装进 商品明细列表
            cart.setOrderItemList(orderItemList);//商品明细列表 装进 购物车对象
            //4.2将新的购物车对象添加到购物车列表中
            cartList.add(cart);//购物车对象 封装进 购物车对象列表
        }else{//5.如果购物车列表中存在该商家的购物车
            //判断该商品是否在购物车列表明细中存在
            List<TbOrderItem> orderItemList = cart.getOrderItemList();
            TbOrderItem orderItem = searchOrderItemByItemId(orderItemList, itemId);

            if(orderItem==null){//5.1如果不存在,创建新的购物车明细对象,并添加商品到该购物车的明细列表中
                orderItem = createOrderItem(item, num);
            }else{//5.2如果存在,在购物车明细列表中进行商品数量合并,并且更新金额
                System.out.println(num.intValue());
                orderItem.setNum(orderItem.getNum()+ num);//数量合并
                System.out.println(orderItem.getNum());
                //金额
                orderItem.setTotalFee(new BigDecimal(orderItem.getNum()*orderItem.getPrice().doubleValue()));//更新总金额
                if(orderItem.getNum()<=0){
                    cart.getOrderItemList().remove(orderItem);//移除购物车明细
                }
                //如果购物车 明细列表 无商品时候 购物车列表 移除此 购物车
                if(cart.getOrderItemList().size()<=0){
                    cartList.remove(cart);
                }
            }
        }

        return cartList;
    }
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<Cart> findCartListFromRedis(String username) {
        System.out.println("从redis中提取购物车数据"+username);
        List<Cart> cartList =(List<Cart>)redisTemplate.boundHashOps("cartList").get(username);
        if(cartList==null){
            cartList=new ArrayList();
        }
        return cartList;
    }

    @Override
    public void saveCartListToRedis(String username, List<Cart> cartList) {
        System.out.println("向redis存入购物车数据....."+username);
        redisTemplate.boundHashOps("cartList").put(username, cartList);
    }

    @Override
    public List<Cart> mergeCartList(List<Cart> cartList1, List<Cart> cartList2) {
        System.out.println("合并购物车");
        for(Cart cart: cartList2){
            for(TbOrderItem orderItem:cart.getOrderItemList()){
                cartList1= addGoodsToCartList(cartList1,orderItem.getItemId(),orderItem.getNum());
            }
        }
        return cartList1;
    }

    /**
     * 根据skuID在购物车明细列表中查询购物车明细对象
     * @param orderItemList
     * @param itemId
     * @return
     */
    private TbOrderItem searchOrderItemByItemId(List<TbOrderItem> orderItemList, Long itemId){
        for (TbOrderItem orderItem : orderItemList) {
            if(orderItem.getItemId().longValue()==itemId.longValue()){
                return orderItem;
            }
        }
        return null;
    }

    /**
     * 创建商品明细对象
     * @param item
     * @param num
     * @return
     */
    private TbOrderItem createOrderItem(TbItem item, Integer num) {
        //新建购物车明细对象
        TbOrderItem orderItem=new TbOrderItem();

        orderItem.setItemId(item.getId());
        orderItem.setPrice(item.getPrice());//单价
        orderItem.setGoodsId(item.getGoodsId());
        orderItem.setNum(num);
        orderItem.setPicPath(item.getImage());
        orderItem.setSellerId(item.getSellerId());
        orderItem.setTitle(item.getTitle());//
        orderItem.setTotalFee(new BigDecimal(item.getPrice().doubleValue()*num));//总价

        return orderItem;
    }

    /**
     * 根据商家Id在购物车列表中查询购物车对象
     * @param cartList
     * @param sellerId
     * @return
     */
    private Cart searchCartBySellerId(List<Cart> cartList, String sellerId) {
        if(cartList.size()<=0){
            return null;
        }
        for (Cart cart : cartList) {
            if(cart.getSellerId().equals(sellerId)){
                return cart;
            }
        }
        return null;
    }


}
