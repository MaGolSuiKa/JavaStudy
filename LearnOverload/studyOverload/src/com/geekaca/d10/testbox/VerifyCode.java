package com.geekaca.d10.testbox;

import java.util.Random;

public class VerifyCode {
    public static void main(String[] args) {

        System.out.println(codeOutput(5));
    }

    public static String codeOutput(int length) {
        char[] codeBox = new char[10 + 26 + 26];
        String codeOutput = new String();
        for (int i = 0; i < 26; i++) {
            codeBox[i] = (char) ('A' + i);
        }
        for (int i = 26; i < 52; i++) {
            codeBox[i] = (char) ('a' + i - 26);
        }
        for (int i = 52; i < 62; i++) {
            codeBox[i] = (char) ('1' + i - 52);
        }
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            codeOutput += codeBox[random.nextInt(62)];
        }
        return codeOutput;
    }
}
