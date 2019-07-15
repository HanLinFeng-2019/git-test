package com;
import java.util.Random;
import java.util.Scanner;

public class day07ZuoYe1 {
    public static void main(String[] args) {
        Scanner S=new Scanner(System.in);
        int num=S.nextInt();
        System.out.println("number:"+num);
//        Array[] arr=new Array[10];
        int [] arr=new int[num];
        //将随机数赋值给数组
        int add=0;
        int max=arr[0];
        for(int i=0;i<num;i++){
            Random r=new Random();
            int a=r.nextInt(100)+1;
            arr[i]= a;
            System.out.println("数组的元素为："+arr[i]);
            //求出数组最大值
            if(arr[i]>max){
                max=arr[i];
            }
            //数组求平均值
            add+=arr[i];
        }
        System.out.println("数组的最大值为："+max);
        double result=(double)add/num;
        System.out.println("数组的平均值为："+result);
    }
}
