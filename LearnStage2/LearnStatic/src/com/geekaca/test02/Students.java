package com.geekaca.test02;

public class Students extends SchoolMembers {
    private String className;

    public void feedback() {
        System.out.println("填写听课反馈");
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    public void showSecret(){
        //子类无法直接访问 父类的私有属性，方法 ,需要通过公共方法访问
        //System.out.println(secret);X
        System.out.println(getSecret());
    }

    @Override
    public String toString() {
        return "Students{" +
                "names='" + names + '\'' +
                ", ages=" + ages +
                ", className='" + className + '\'' +
                '}';
    }
}
