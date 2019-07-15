package com.itheima.HongBao;

import java.util.ArrayList;

public class Manager extends User {

    public Manager() {

    }

    public Manager(String name, int money) {
        super(name, money);
    }
    public ArrayList<Integer> send(int totalMoney,int count){
        ArrayList<Integer> redList=new ArrayList<>();
        //判断群主余额是否充足
        int leftMoney=getMoney();
        if(totalMoney>leftMoney){
            System.out.println("余额不足");
            return redList;
        }
        //显示群主剩余 余额
        super.setMoney(leftMoney-totalMoney);
        //
        int avg=totalMoney/count;//均分
        int mod=totalMoney%count;//均分以后的零头
           for(int i=0;i<count-1;){
               redList.add(avg);
           }
           int last=avg+mod;
           redList.add(last);
            return redList;
    }
}
