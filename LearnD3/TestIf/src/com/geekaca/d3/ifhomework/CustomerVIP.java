package com.geekaca.d3.ifhomework;

import java.util.Scanner;

public class CustomerVIP {
    public static void main(String[] args) {
        /**
         *
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入顾客身份:（0 普通顾客 1会员）");
        int customerType = scanner.nextInt();
        if (customerType != 0 && customerType != 1){
            System.out.println("顾客类型输入有误");
            //中断当前函数的执行，后续代码不会执行了
            return;
        }
        System.out.println("请输入消费金额：");
        double costMoney = scanner.nextDouble();
        switch (customerType){
            case 0:
                //普通顾客
                if(costMoney >= 100){
                    System.out.println("您消费: "+ costMoney+ "元 打9折后需要支付: "+ costMoney * 0.9);
                }else{
                    System.out.println("无折扣，需要支付: "+ costMoney);
                }
                break;
            case 1:
                //VIP
                if(costMoney >= 200){
                    System.out.println("您消费: "+ costMoney+ "元 打7.5折后需要支付: "+ costMoney * 0.75);
                }else{
                    System.out.println("您消费: "+ costMoney+ "元 打8折后需要支付: "+ costMoney * 0.8);
                }
                break;
            default:
                System.out.println("顾客类型有误");
                break;
        }

    }
}
