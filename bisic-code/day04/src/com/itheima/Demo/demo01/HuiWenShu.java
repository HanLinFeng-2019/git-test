package com.itheima.Demo.demo01;

public class HuiWenShu {
    public static void main(String[] args) {
        int sum=0;
        for(int a=1;a<=9;a++){
            for(int b=0;b<=9;b++){
                for(int c=0;c<=9;c++){
                    for(int d=0;d<=9;d++){
                        for(int e=0;e<=9;e++){
                            if(e == a && b == d){
                                System.out.print(10000*a+1000*b+100*c+10*d+e+"  ");
                                sum++;
                                if(sum%5==0){
                                    System.out.println();
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("总共："+sum);
    }
}
