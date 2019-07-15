package com.itheima.Demo.demo01;

public class exam03 {
    public static void main(String[] args) {
        int[] array={1,5,8,9,8,10,6,5,4,2,8};
        int max=array[0];
        int min=array[0];
        int add=0;
        for(int i=1;i<array.length;i++){
            add+=array[i];
            while(array[i]>max){
                max=array[i];
            }
            while(array[i]<min){
                min=array[i];
            }
            double num=(add-min-max+array[0])/(array.length-2);
            System.out.println("平均得分是："+num);
        }
        System.out.println("去掉一个最高分："+max);
        System.out.println("去掉一个最低分："+min);
        /*System.out.println("去掉一个最高分："+max);
        for(int i=1;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
            }
        }
        System.out.println("去掉一个最低分："+min);
        for(int i=0;i<array.length;i++){
            add+=array[i];
        }
        double num=(add-min-max)/(array.length-2);
        System.out.println("平均得分是："+num);*/
    }
}
