package com.geekaca.d3;

public class TestIf {
    public static void main(String[] args) {
        /**
         * if 分支
         */
        int heartBeat = 90;
        // if(条件表达式)
        boolean noOk = heartBeat < 60 || heartBeat > 100;
        //if 内容只有一句，大括号可以省略，但是不推荐
        if (noOk){
            System.out.println("心跳数据是: "+ heartBeat + " 您可能需要进一步检查");
        }else{
            System.out.println("您的心跳正常");
        }
        System.out.println("-------------------");
        //绩效   写代码要避免 区间的重叠
        int score = 90;
        if(score >= 0 && score < 60){
            System.out.println("绩效C");
        }else if(score >= 60 && score < 90){
            System.out.println("绩效B");
        }else if(score >= 80 && score <= 90){
            System.out.println("绩效A");
        }else if(score >= 90 && score <= 100){
            System.out.println("绩效A+");
        }else{
            System.out.println("绩效分数值错误");
        }
    }
}
