package com.itheima.Demo;

import java.util.Scanner;

public class Practise1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String input=sc.next();


        int countUpper=0;//大写字母
        int countLower=0;//小写字母
        int countNumber=0;//数字
        int countOther=0;//其他字符

        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if('A'<=ch&&ch<='Z'){
                countUpper++;
            }else if('a'<=ch&&ch<='z'){
                countLower++;
            }else if('0'<=ch&&ch<='9'){
                countNumber++;
            }else{
                countOther++;
            }
        }
        System.out.println("大写字母的个数:"+countUpper);
        System.out.println("小写字母的个数:"+countLower);
        System.out.println("数字的个数:"+countNumber);
        System.out.println("其他字符的个数:"+countOther);
    }
}
