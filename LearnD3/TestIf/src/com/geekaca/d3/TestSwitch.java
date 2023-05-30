package com.geekaca.d3;

public class TestSwitch {
    public static void main(String[] args) {
        String weekDay = "周三";
        // 周一：埋头苦干，解决bug                                  周五：今晚吃鸡
        // 周二：请求大牛程序员帮忙                             周六：与王婆介绍的小芳相亲
        // 周三：今晚啤酒、龙虾、小烧烤                              周日：郁郁寡欢、准备上班。
        // 周四： 主动帮助新来的女程序解决bug
        switch(weekDay){
            case "周一":
                System.out.println("周一：埋头苦干，解决bug");
                break;
            case "周二":
                System.out.println("周二：请求大牛程序员帮忙");
                break;
            case "周三":
                System.out.println("周三：今晚啤酒、龙虾、小烧烤 ");
                break;
            case "周四":
                System.out.println("周四： 主动帮助新来的女程序解决bug");
                break;
            case "周五":
                System.out.println("周五：今晚吃鸡");
                break;
            case "周六":
                System.out.println("周六：与王婆介绍的小芳相亲");
                break;
                //不允许重复case
//            case "周六":
//                System.out.println("周日：郁郁寡欢、准备上班");
//                break;
            default:
                System.out.println("日期有误");
                break;


        }
//        long distance = 5000L;
//        switch (distance){
//
//        }
//        String friday = "周五";
//        switch (weekDay){
//            //case 跟的要求常量表达式（字面量）
//            case friday:
//                break;
//        }

    }
}
