package com.geekaca.homework.test1;

public class Mouse extends USB {
    @Override
    public void putIn() {
        System.out.println("usb鼠标插入");
    }

    @Override
    public void putOut() {
        System.out.println("usb鼠标拔出");
    }
}
