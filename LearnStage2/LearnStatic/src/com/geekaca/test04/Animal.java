package com.geekaca.test04;

public class Animal {
    private String name;

    public Animal() {
        System.out.println("Animal() 无参数构造器.");
    }

    public Animal(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("动物跑");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
