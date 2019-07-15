package com.itheima.Demo.demo01;

public class SellChicken {
    public static void main(String[] args) {
        for(int male=0;male<=20;male++){
            for(int female=0;female<=33;female++){
                for(int little=0;little<=300;little++){
                    if(male+female+little==100&&male*5+female*3+(little/3)==100){
                        System.out.println("male:"+male+"  "+"female:"+female+"  "+"little:"+little+"\t");
                    }
                }
            }
        }
    }
}
