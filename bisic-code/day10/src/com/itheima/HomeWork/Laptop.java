package com.itheima.HomeWork;

public class Laptop {
    public void PowerOn(){
        System.out.println("笔记本开机");
    }
    public void powerOff(){
        System.out.println("笔记本关机");
    }
    public void useDevice(USB usb){
        usb.Open();//打开usb设备
        usb.Close();//关闭usb设备
    }

}
