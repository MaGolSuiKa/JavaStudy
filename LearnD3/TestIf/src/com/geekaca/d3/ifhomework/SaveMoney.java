package com.geekaca.d3.ifhomework;

import java.util.Scanner;

public class SaveMoney {
    public static void main(String[] args) {
        /**
         * 存期		年利率（%）
         *
         * 	一年		2.25%
         *
         * 	两年		2.7%
         *
         * 	三年		3.25%
         *
         * 	五年		3.6%
         *
         * 	本金+本金×年利率×年限
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要存的金额(至少1000):");
        int money = scanner.nextInt();
        if (money < 1000) {
            System.out.println("存款最少1000起");
        } else {
            System.out.println("请输入存款年限(1, 2, 3, 5)：");
            int year = scanner.nextInt();
            //定义  赋值
            double shouyi = 0;
            switch (year) {
                case 1:
                    //收益  赋值
                    shouyi = money + money * 2.25 * 0.01 * 1;
                    System.out.println("1年存" + money + " 最终收益：" + shouyi);
                    break;
                case 2:
                    //收益 在每个case中定义的变量不能冲突，因为属于同一个作用范围
                    shouyi = money + money * 2.7 * 0.01 * 2;
                    System.out.println("2年存" + money + " 最终收益：" + shouyi);
                    break;
                case 3:
                    shouyi = money + money * 3.25 * 0.01 * 3;
                    System.out.println("3年存" + money + " 最终收益：" + shouyi);
                    break;
                case 5:
                    shouyi = money + money * 3.6 * 0.01 * 5;
                    System.out.println("5年存" + money + " 最终收益：" + shouyi);
                    break;
                default:
                    System.out.println("输入年限错误，只能是1 2 3 5");
                    break;
            }
        }
    }
}
