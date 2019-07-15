package com.itheima.HomeWork2;

public class Feeder extends Animal{


    public Feeder() {
        super.drink();
    }

    @Override
    public void eat() {
        System.out.println("饲养");
    }

}
