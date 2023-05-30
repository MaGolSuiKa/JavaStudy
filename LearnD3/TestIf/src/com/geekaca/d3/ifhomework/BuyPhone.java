package com.geekaca.d3.ifhomework;

public class BuyPhone {
    public static void main(String[] args) {
        /**
         * 手机购买 省钱方式
         *
         *  要买的  7988
         *
         * 1， 手里的手机 值 1500    7988-1500
         * 2， 7988 * 0.8  以旧换新
         */

        //要买的手机价格
        double phoneCost = 7988;
        //我的手机值 多杀钱
        double myPhoneValue = 1500;
        double cost1 = phoneCost - myPhoneValue;
        System.out.println("直接卖自己手机方案，支出价格："+ cost1);

        double cost2 = phoneCost * 0.8D;
        //字符串格式化，保留小数点后两位（四舍五入）
        String result = String.format("%.2f", cost2);
        System.out.println("依旧换新方案,支出价格："+ result);
    }
}
