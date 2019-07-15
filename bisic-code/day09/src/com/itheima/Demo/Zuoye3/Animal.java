package com.itheima.Demo.Zuoye3;

public abstract class Animal {
    private int age;
    private String color;
    public abstract void eat(String something);
    public Animal(){

    }
    public Animal(int age, String name) {
        this.age = age;
        this.color = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return color;
    }

    public void setName(String name) {
        this.color = name;
    }
}
