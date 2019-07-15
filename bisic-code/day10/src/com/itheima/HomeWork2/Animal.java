package com.itheima.HomeWork2;

public abstract class Animal {
    private int age;

    public Animal() {

    }

    public Animal(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void drink(){
        System.out.println("喝水");
    }
    public abstract void eat();
}
