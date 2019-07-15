package com.itheima.Exam31;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
    public static void main(String[] args) {
        System.out.println("系统产生一个50~60之间的随机数，请猜出这个数字：");
        Random r=new Random();
        int num=r.nextInt(11)+50;
        while(true){
            Scanner a=new Scanner(System.in);
            int put=a.nextInt();
            if(put>num){
                System.out.println("比生成的随机数大，请继续猜");
            }else if(put<num){
                System.out.println("比生成的随机数小，请继续猜");
            }else{
                System.out.println("恭喜你，猜中了");
                break;
            }
        }
    }
}
