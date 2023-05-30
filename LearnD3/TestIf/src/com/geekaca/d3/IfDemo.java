package com.geekaca.d3;

import java.util.Scanner;

public class IfDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你的分数，等待惊喜");
        //alt + 回车
        double score = scanner.nextDouble();
        // 0----80 --89 90 - 94 95-100
        if(score >= 0 && score < 80){
            System.out.println("要挨揍");
        }else if(score >= 80 && score < 90){
            System.out.println("变形金刚");
        }else if(score >= 90 && score < 95 ){
            System.out.println("游乐园");
        }else if(score >= 95 && score <= 100){
            System.out.println("自行车");
        }else{
            // < 0 或者  > 100
            System.out.println("分数值不合理");
        }
    }
}
