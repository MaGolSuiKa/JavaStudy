package com.geekaca.homework.test2;

public class Doujiang extends Doujiangji{
    public Doujiang() {
        System.out.println("开始做豆浆");
    }

    @Override
    public void wash() {
        System.out.println("洗豆子");
    }

    @Override
    public void putIn() {
        System.out.println("放入豆子");
    }
}
