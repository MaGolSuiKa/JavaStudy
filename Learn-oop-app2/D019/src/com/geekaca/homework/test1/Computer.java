package com.geekaca.homework.test1;

public class Computer {
    public void putInAndOutUsb(USB usb){
        usb.putIn();
        System.out.println("执行操作");
        usb.putOut();
    }
}

