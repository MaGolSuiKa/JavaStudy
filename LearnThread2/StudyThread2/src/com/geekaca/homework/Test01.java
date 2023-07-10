package com.geekaca.homework;

//      1，利用线程模拟车站卖票
//        只有20张票
//        三个售票窗口卖票

public class Test01 {
    public static void main(String[] args) {
        Ticket t = new Ticket(20);
        SaleTicket stt1 = new SaleTicket(t);
        SaleTicket stt2 = new SaleTicket(t);
        SaleTicket stt3 = new SaleTicket(t);

        Thread thread1 = new Thread(stt1,"A窗口");
        Thread thread2 = new Thread(stt2,"B窗口");
        Thread thread3 = new Thread(stt3,"C窗口");
        thread3.start();
        thread1.start();
        thread2.start();
    }
}
