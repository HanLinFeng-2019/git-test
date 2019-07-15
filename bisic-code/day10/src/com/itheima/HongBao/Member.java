package com.itheima.HongBao;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {

    }

    public Member(String name, int money) {
        super(name, money);
    }
    public void receive(ArrayList<Integer> list){
       /* Random r=new Random();
        //随机生成一个红包集合的索引值
        int index=r.nextInt(list.size());*/
        int index = new Random().nextInt(list.size());
        //删除集合中随机的红包索引值对应的钱数
        int delta=list.remove(index);
        int money = super.getMoney();
        //同时普通用户接收这个钱
        super.setMoney(delta+money);

    }
}
