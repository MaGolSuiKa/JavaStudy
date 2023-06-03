package com.geekaca.d10.testbox;

import java.util.Scanner;

public class BuyTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = scanner.nextInt();
        System.out.println("请输入（头等舱1，经济舱2）：");
        int level = scanner.nextInt();
        System.out.println("请输入机票原价：");
        double ticketPrices = scanner.nextDouble();
        ticketInput(month, level, ticketPrices);
    }

    public static void ticketInput(int month, int level, double ticketPrices) {
        if (month >= 5 && month <= 10) {
            System.out.println("当月是旺季");
            switch (level){
                case 1:
                    System.out.println("头等舱");
                    System.out.println("折扣后票价为：" + (ticketPrices * 0.9));
                    break;
                case 2:
                    System.out.println("经济舱");
                    System.out.println("折扣后票价为：" + (ticketPrices * 0.7));
                    break;
                default:
                    System.out.println("输入有误");
            }

        } else if ((month >= 1 && month <= 4) || (month >= 11 && month <= 12)) {
            System.out.println("当月是淡季");
            switch (level){
                case 1:
                    System.out.println("头等舱");
                    System.out.println("折扣后票价为：" + (ticketPrices * 0.85));
                    break;
                case 2:
                    System.out.println("经济舱");
                    System.out.println("折扣后票价为：" + (ticketPrices * 0.65));
                    break;
                default:
                    System.out.println("输入有误");
            }
        }else {
            System.out.println("月份输入有误");
        }

    }
}
