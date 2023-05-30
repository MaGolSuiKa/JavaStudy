package com.geekaca.d3.testwhile;

public class TestBreak {
    public static void main(String[] args) {
        /**
         * break 和continue
         *
         *  1~30 老婆让你刷碗
         */

//        for (int i = 1; i <= 30; i++) {
//            System.out.println("刷碗第" + i+ "天");
//            if (i == 12){
//                break;
//            }
//        }

//        for (int i = 1; i <= 30; i++) {
//            // 12 13 这两天 你家孩子惹祸了，孩子刷，后面还是你
//            if (i == 12 || i == 13) {
//                //continue 结束当前循环，继续下次
//                continue;
//            }
//            System.out.println("刷碗第" + i + "天");
//        }
        //不推荐
        OUTTAG:
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10 ; j++) {
                if (j == 2){
                    break OUTTAG;
                }
                System.out.println(i + " "+ j);
            }
        }
        //
    }
}
