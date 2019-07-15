app.service("cartService",function($http){
    //查看购物车列表
    this.findCartList=function(){
        return $http.get('cart/findCartList.do');
    }
    //商品添加进购物车
    this.addGoodsToCartList=function(itemId,num){
        return $http.get('cart/add.do?itemId='+itemId+'&num='+num);
    }

    this.sum=function(cartList){
        var totalValue={totalNum:0, totalMoney:0.00 };//合计实体
        for(var i=0;i<cartList.length;i++){
            var cart=cartList[i];
            for(var j=0;j<cart.orderItemList.length;j++){
                var orderItem=cart.orderItemList[j];//购物车明细
                totalValue.totalNum+=orderItem.num;
                totalValue.totalMoney+= orderItem.totalFee;
            }
        }
        return totalValue;
    }
    //获取当前用户收获地址
    this.findAddressList=function(){
        return $http.get('address/findListByLoginUser.do');
    }

    this.submitOrder=function(order){
        return $http.post('order/add.do',order);
    }
});