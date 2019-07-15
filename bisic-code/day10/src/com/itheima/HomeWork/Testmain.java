package com.itheima.HomeWork;

public class Testmain {
    public static void main(String[] args) {
        Laptop laptop=new Laptop();
        laptop.PowerOn();

        USB usbMouse= new Mouse();
        laptop.useDevice(usbMouse);

        USB usbKeyBoard=new KeyBoard();
        laptop.useDevice(usbKeyBoard);

        laptop.powerOff();
    }
}
