package com.itheima.Demo.demo01;

public class MethodPrint {
    public static void main(String[] args) {
        printCount(10);
    }
    public static void printCount(int num){
        for(int i=0;i<num;i++){
            System.out.println("Hello,World!"+(i+1));
        }
    }
}
