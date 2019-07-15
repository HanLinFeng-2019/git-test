package com.itheima.HomeWork2;

public class Test {
    public static void main(String[] args) {
        Animal f = new Feeder();
        Dog d=(Dog)f;
        d.eat();
        d.drink();
        d.swiming();
    }
}