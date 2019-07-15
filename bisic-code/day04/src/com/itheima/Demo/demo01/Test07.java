package com.itheima.Demo.demo01;

public class Test07 {
    public static void main(String[] args) {
        //1.公鸡最多买100/5只，母鸡最多100/3只， 小鸡最多 100只,进行循环
        for (int gong = 0; gong <= 100 / 5 ; gong++) {
            for (int mu = 0; mu < 100 / 3; mu++) {
                int xiao = 100 - gong - mu;
                //2.条件判断：gong*5+mu*3+xiao/3== 100  ,xiao % 3 == 0
                if (gong*5+mu*3+xiao/3 == 100 && xiao% 3 == 0) {
                    System.out.println("公鸡："+gong+"只，母鸡"+mu+"只，小鸡"+xiao+"只");
                }
            }
        }
    }
}
