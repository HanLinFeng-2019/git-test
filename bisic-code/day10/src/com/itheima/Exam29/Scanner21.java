package com.itheima.Exam29;

import java.util.Scanner;

public class Scanner21 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        while(true){
            Scanner sc=new Scanner(System.in);
            String str=sc.next();
            int num1=0;
            int num2=0;
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if('A'<=ch&&ch<='z'){
                    num1++;
                    if('A'<=ch&&ch<='Z'){
                        num2++;
                    }
                }
            }
            if(num1==0){
                System.out.println("输入错误,请重新输入带字母的字符串：");
            }else{
                System.out.println("输入的字符串含大写字母"+num2+"个");
                break;
            }

        }
    }
}
