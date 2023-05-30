package com.geekaca.d3.testwhile;

public class MontainHeight {
    public static void main(String[] args) {
        /**
         * 单位统一
         * 8848.86米 * 1000  = 毫米
         * 纸张厚度 0.1毫米
         *
         * 0.1 *2 对折一次   0.2
         * 0.2 * 2  对折两次 0.4
         * 0.4 * 2 = 0.8  3
         * 0.8 * 2 = 1.6  4
         *
         * 不断对折，每次都去和珠峰高度比较 ，看看是不是已经大于等于珠峰高度了
         *
         * 当 (当前折纸的厚度 还小于 珠峰高度的时候){
         *
         *     继续折叠
         * }
         */
        //一张纸的厚度   mm
        double zhiHoudu = 0.2;
        //珠峰的高度(毫米)
        double zhufenggaodu = 8848.86 * 1000;
        //当前折纸 已经达到的厚度    最初厚度
        double dangqianHoudu = zhiHoudu;
        //循环执行的次数
        int count = 0;
        while (dangqianHoudu < zhufenggaodu) {
            //每次对折   ,每折叠一次，循环体都会执行一边，一次
            dangqianHoudu = dangqianHoudu * 2;
            count++;
        }
        //如何 计算 折叠了多少次？
        System.out.println("最终折纸厚度：" + dangqianHoudu);
        System.out.println("折叠的次数：" + count);
    }
}
