package com.geekaca.homework.test1;

import java.util.ArrayList;

public class TestMain1 {
    public static void main(String[] args) {
        USB usb1 = new Mouse();
        USB usb2 = new Keyboard();

        Computer computer = new Computer();
        computer.putInAndOutUsb(usb1);
        computer.putInAndOutUsb(usb2);

        System.out.println("=========================");
        ArrayList<USB> usbs = USBList.USB_LIST.usbArrayList;
        usbs.add(usb1);
        usbs.add(usb2);

        for (int i = 0; i < usbs.size(); i++) {
            computer.putInAndOutUsb(usbs.get(i));
        }
    }
}
