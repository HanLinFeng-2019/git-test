package com.itheima.HomeWork;

public class Mouse implements USB {
    @Override
    public void Open() {
        System.out.println("鼠标开启，红灯闪闪");
    }

    @Override
    public void Close() {
        System.out.println("鼠标关闭，红灯熄灭");
    }
    public void Click(){
        System.out.println("鼠标单击");
    }
}
