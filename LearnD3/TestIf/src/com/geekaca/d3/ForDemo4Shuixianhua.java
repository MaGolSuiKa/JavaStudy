package com.geekaca.d3;

public class ForDemo4Shuixianhua {
    public static void main(String[] args) {
        /**
         * 求水仙花数
         * 1, 三位数
         * 2，各个位的立方和 = 数本身
         * 153
         * 1  1
         * 5*5*5=125
         * 3*3*3 = 27
         * ->  1+125+27=153
         */

        /**
         * 拆解问题
         * 判断一个数，是否是水仙花数
         */
//        int num1 = 153;
        //128 苹果 ，分给10个人，剩余几个
//        int gewei = num1 % 10;//余数8
//        int shiwei = num1 /10 % 10;
//        int baiwei = num1 /10 /10 % 10;
//        //各个位的立方
//        int gwLifang = gewei * gewei * gewei;
//        int shwLifang = shiwei * shiwei * shiwei;
//        int bwLifang = baiwei * baiwei * baiwei;
//        System.out.println("个位立方和："+ gwLifang);
//        System.out.println("十位立方和："+ shwLifang);
//        System.out.println("百位立方和："+ bwLifang);
//        int zonghe = gwLifang + shwLifang + bwLifang;
//        System.out.println("总和：" + zonghe);
//        if(zonghe == num1){
//            System.out.println(num1 + "是水仙花数");
//        }else{
//            System.out.println(num1 + "不是水仙花数");
//        }
        //保存 水仙花数量
        int shuixianCount = 0;
        for (int num1 = 100; num1 <= 999; num1++) {
            int gewei = num1 % 10;//余数8
            int shiwei = num1 / 10 % 10;
            int baiwei = num1 / 10 / 10 % 10;
            //各个位的立方
            int gwLifang = gewei * gewei * gewei;
            int shwLifang = shiwei * shiwei * shiwei;
            int bwLifang = baiwei * baiwei * baiwei;
//            System.out.println("个位立方和："+ gwLifang);
//            System.out.println("十位立方和："+ shwLifang);
//            System.out.println("百位立方和："+ bwLifang);
            int zonghe = gwLifang + shwLifang + bwLifang;
//            System.out.println("总和：" + zonghe);
            if (zonghe == num1) {
                System.out.println(num1 + "是水仙花数");
                shuixianCount++;
            } else {
//                System.out.println(num1 + "不是水仙花数");
            }
        }
        System.out.println("水仙花数量" + shuixianCount);
    }
}
