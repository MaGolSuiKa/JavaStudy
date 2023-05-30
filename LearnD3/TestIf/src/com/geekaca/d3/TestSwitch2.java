package com.geekaca.d3;

public class TestSwitch2 {
    public static void main(String[] args) {
        /**
         * switch的穿透现象
         */
//        String weekday = "周一";
//        switch (weekday){
//            case "周一":
//                System.out.println("周一：埋头苦干，解决bug ");
////                break;
//            case "周二":
//                System.out.println("周二：请求大牛程序员帮忙");
//                break;
//            case "周三":
//                System.out.println("3今晚啤酒、龙虾、小烧烤");
//                break;
//            case "周四":
//                System.out.println("4主动帮助新来的女程序解决bug");
//                break;
//            case "周五":
//                System.out.println("5今晚吃鸡");
//                break;
//            case "周六":
//                System.out.println("6与王婆介绍的小芳相亲");
//                break;
//            case "周日":
//                System.out.println("7郁郁寡欢、准备上班");
//                break;
//            default:
//                System.out.println("数据有误！");
//        }
        // 1、3 、5、 7 、 8、 10、 12月份是 31天
        //2 28天
        // 4 、6 、9、 11月份 是30天
        int month = 9;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month + " 月有31天");
                break;
            case 2:
                System.out.println(month + " 月有28天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + "是30天！");
                break;
            default:
                System.out.println("月份有误！");
                break;

        }
    }
}
