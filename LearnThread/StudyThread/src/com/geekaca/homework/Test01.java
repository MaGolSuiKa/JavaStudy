package com.geekaca.homework;

//        练习：多线程 计数
//        给定一个数2000
//        从1打印到2000
//        用多个线程同时进行打印，打印同一个变量，+
public class Test01 {

    public static void main(String[] args) {

        NumsTarget numsTarget = new NumsTarget(1,100);
        CountPuls thread1 = new CountPuls("A线程",numsTarget);
        CountPuls thread2 = new CountPuls("B线程",numsTarget);
        CountPuls thread3 = new CountPuls("C线程",numsTarget);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
