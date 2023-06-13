package com.geekaca.test04;

public class Bird extends Animal{
    public Bird(String name) {
        super(name);
        //明确调用父类的有参构造器，就不会自动调用父类无参构造器了
    }

    @Override
    public void run() {
        System.out.println(getName() + "鸟儿蹦哒");
    }
}
