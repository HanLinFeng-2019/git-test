package com.itheima.Demo.demo01;

public class Game7 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 7 == 0 || i / 10 % 10== 7 || i % 10 == 7) {
                System.out.print(i + "\t");
                sum += 1;
                if (sum % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
