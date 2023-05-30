package com.geekaca.d3.ifhomework;
//IDEA 自动导入了包

import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        //键盘录入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int a = scanner.nextInt();
        System.out.println("请输入第二个数：");
        int b = scanner.nextInt();
        System.out.println("请输入第三个数：");
        //alt + 回车
        int c = scanner.nextInt();
        //三元运算符
        int tmp = a > b ? a : b;
        int max = tmp > c ? tmp : c;
        //ctrl + alt + L 代码格式化
        System.out.println("最大的值：" + max);

    }
}
