package com.itheima.Demo.demo01;

public class Tree {
    public static void main(String[] args) {
        int sum=0;
        for(int a=1;a<=9;a++){
            for(int b=0;b<=9;b++){
                for(int c=0;c<=9;c++){
                    for(int d=0;d<=9;d++){
                        if((d+b==c+a)&(a%2!=0)&(d%2==0)){
                            System.out.print(1000*a+100*b+10*c+d+"\t");
                            sum++;
                            if(sum%5==0){
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
        System.out.println("总共："+sum);
    }
}
