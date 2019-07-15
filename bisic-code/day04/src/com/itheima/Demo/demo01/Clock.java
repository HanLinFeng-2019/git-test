package com.itheima.Demo.demo01;

public class Clock {
    public static void main(String[] args) {
        for(int hour=0;hour<24;hour++){
            for(int minute=0;minute<60;minute++){
                for(int second=0;second<60;second++){
                    System.out.println(hour+":"+minute+":"+second);
                }
            }
        }
    }

}
