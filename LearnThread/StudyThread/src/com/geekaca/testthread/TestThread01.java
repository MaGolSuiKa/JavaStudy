package com.geekaca.testthread;

public class TestThread01 {
    public static void main(String[] args) {
        MyThreads threads1= new MyThreads();
        MyThreads threads2= new MyThreads();
        OtherThread threads3 = new OtherThread();
        threads2.start();
        threads1.start();
        threads3.start();
    }
}
class MyThreads extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class  OtherThread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("System.currentTimeMillis()");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}