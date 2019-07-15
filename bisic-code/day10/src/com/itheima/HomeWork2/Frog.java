package com.itheima.HomeWork2;

public class Frog extends Animal implements Swim{
    public Frog() {
        super.drink();
    }

    @Override
    public void eat() {
        System.out.println("吃虫子");
    }


    @Override
    public void swiming() {
        System.out.println("蛙泳");
    }
}
