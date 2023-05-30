package com.geekaca.d3.ifhomework;

import java.util.Scanner;

/**
 * 计算器
 */
public class MyCalculator {
    public static void main(String[] args) {
        // 2.创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        // 3.提示需要输入的数据，并调用方法获取输入的数据
        System.out.println("请输入第一个整数：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个整数：");
        int num2 = sc.nextInt();
        System.out.println("请输入您要进行的运算(1:表示加法,2:表示减法,3:表示乘法,4:表示除法)");
        int type = sc.nextInt();
        // 4.使用switch语句判断计算类型，并输出相应的结果
        switch (type) {
            case 1:
                System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
                break;
            case 2:
                System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
                break;
            case 3:
                System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
                break;
            case 4:
                System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }
}
