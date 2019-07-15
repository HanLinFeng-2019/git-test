package com.itheima.HomeWork;

public class KeyBoard implements USB {

    @Override
    public void Open() {
        System.out.println("指示灯亮");
    }

    @Override
    public void Close() {
        System.out.println("指示灯灭");
    }
}
