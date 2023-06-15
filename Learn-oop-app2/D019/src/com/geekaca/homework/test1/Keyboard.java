package com.geekaca.homework.test1;

public class Keyboard extends USB {
    @Override
    public void putIn() {
        System.out.println("usb键盘接入");
    }

    @Override
    public void putOut() {
        System.out.println("usb键盘拔出");
    }
}
