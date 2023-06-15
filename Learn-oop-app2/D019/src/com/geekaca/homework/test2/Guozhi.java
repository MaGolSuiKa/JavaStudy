package com.geekaca.homework.test2;

public class Guozhi extends Doujiangji{
    public Guozhi() {
        System.out.println("开始做果汁");
    }

    @Override
    public void wash() {
        System.out.println("洗水果");
        System.out.println("切块");
    }

    @Override
    public void putIn() {
        System.out.println("放入水果块");
    }
}
