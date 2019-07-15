package com.itheima.HomeWork2;

public class Sheep extends Animal {
    public Sheep() {
        super.drink();
    }

    @Override
    public void eat() {
        System.out.println("羊啃草");
    }

    @Override
    public void swiming() {

    }
}
