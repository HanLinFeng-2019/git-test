package com.itheima.Exam32;

public class Line {
    private String emplymentClass;//就业班
    private int money;//学费

    public Line() {

    }
    public Line(String emplymentClass, int money) {
        this.emplymentClass = emplymentClass;
        this.money = money;
    }

    public String getEmplymentClass() {
        return emplymentClass;
    }

    public void setEmplymentClass(String emplymentClass) {
        this.emplymentClass = emplymentClass;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
