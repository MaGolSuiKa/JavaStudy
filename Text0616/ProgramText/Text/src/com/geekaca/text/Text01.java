package com.geekaca.text;

public class Text01 {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 2) {
                    System.out.print("#");
                } else {
                    System.out.print("@");
                }
            }
            System.out.println();
        }
    }
}
