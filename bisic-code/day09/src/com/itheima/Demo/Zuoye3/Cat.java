package com.itheima.Demo.Zuoye3;

public  class Cat extends Animal {
    @Override
    public void eat(String something){
        System.out.println("猫吃"+something);
    }
    public void catchMouse(){
        System.out.println("抓老鼠");
    }
}
