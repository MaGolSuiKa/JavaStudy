package com.geekaca.d10.testbox;

import java.util.Arrays;

public class ArrCopy {
    public static void main(String[] args) {
        int[] arrays = {11, 22, 33, 44, 55};
        System.out.println("原数组为：" + Arrays.toString(arrays));

        int[] arrC = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            arrC[i] = arrays[i];
        }
        System.out.println("复制完成，内容为：" + Arrays.toString(arrC));
    }
}
