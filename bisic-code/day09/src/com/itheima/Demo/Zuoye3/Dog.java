package com.itheima.Demo.Zuoye3;

public class Dog extends Animal{
    @Override
    public void eat(String something) {
        System.out.println("狗吃"+something);
    }
    public void lookHome(){
        System.out.println("狗看家");
    }
}
