package com.geekaca.test02;

public class SchoolMembers {
    public String names;
    public int ages;

    private String secret = "mimi";

    public String getSecret() {
        return secret;
    }

    public void check() {
        System.out.println("查看课表");
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }

    public static void hello() {
        System.out.println("hello");
    }
}
