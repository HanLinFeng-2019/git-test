package com.itheima.Demo;

import java.util.Scanner;

public class day08HomeWork1 {
    public static void main(String[] args) {
        Scanner big=new Scanner(System.in);
        Scanner small=new Scanner(System.in);
        String Str=big.next();
        String Str2=small.next();
        int length1=Str.length();
        int length2=Str2.length();
        int num=0;
        for(int i=0;i<Str.length();i++){
            if(Str.substring(i,i+Str2.length()).equals(Str2)){
                num++;
            }
        }
        System.out.println("共出现"+num+"次");
    }
}
