package com.itheima.HomeWork2;

public class Dog extends Animal implements Swim {
    public Dog() {
        super.drink();
    }

    @Override
    public void eat() {
        System.out.println("啃骨头");
    }

    @Override
    public void swiming() {
        System.out.println("狗刨");
    }
}
