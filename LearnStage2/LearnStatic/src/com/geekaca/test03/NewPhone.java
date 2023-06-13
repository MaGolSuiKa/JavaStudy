package com.geekaca.test03;

public class NewPhone extends Phone {
    //方法重写  override ,java编译器语法检查的方式，不写也可以

    @Override
    public void call() {
        //super指向父类
        super.call();
        /**
         * 既具备父类的功能
         * 还可以加额外的功能
         */
        System.out.println("还可以发送语音电话");
    }

    @Override
    public void sendMsg() {
        super.sendMsg();
    }
    //不允许重写静态方法
//    @Override
//    public static void show() {
//
//    }
}
