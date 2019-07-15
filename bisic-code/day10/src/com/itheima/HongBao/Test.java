package com.itheima.HongBao;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //创建一个对象 张三 余额200元
        Manager manager=new Manager("张三",200);

       /* Scanner sc=new Scanner(System.in);
        System.out.println("请输出红包金额");
        int money=sc.nextInt();
        System.out.println("请输出红包个数");
        int count=sc.nextInt();*/

        Member one=new Member("A",0);
        Member two=new Member("B",0);
        Member three=new Member("C",0);
        //显示余额
        manager.show();
        one.show();
        two.show();
        three.show();
        //
        ArrayList<Integer> redList = manager.send(20, 3);
        one.receive(redList);
        two.receive(redList);
        three.receive(redList);
        //
        manager.show();
        one.show();
        two.show();
        three.show();
    }
}
