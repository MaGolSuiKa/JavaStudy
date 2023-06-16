package com.geekaca.text;

import java.util.ArrayList;

public class Text07 {
    public static void main(String[] args) {
        int[] nums1 = {3, 6, 1, 0};
        System.out.println(findTwice(nums1));
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(findTwice(nums2));
        int[] nums3 = {1};
        System.out.println(findTwice(nums3));
    }

    public static int findTwice(int[] nums) {
        if (nums == null) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        } else {
//            int temp = nums[0];
//            int maxNum = 0;
//            boolean isTwice = true;
//            for (int i = 0; i < nums.length; i++) {
//                if (temp < nums[i]) {
//                    temp = nums[i];
//                    maxNum = i;
//                }
//            }
//            for (int i = 0; i < nums.length; i++) {
//                if (temp <= nums[i] * 2) {
//                    isTwice = false;
//                }
//            }
//            if (!isTwice) {
//                return -1;
//            } else {
//                return maxNum;
//            }

            ArrayList<Integer> integers = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                integers.add(nums[i]);
            }
            int temp = integers.get(0);
            int maxNum = 0;
            boolean isTwice = true;

            for (int i = 0; i < integers.size(); i++) {
                if (temp < integers.get(i)) {
                    temp = integers.get(i);
                    maxNum = i;
                }
            }
            integers.remove(maxNum);

            for (int i = 0; i < integers.size(); i++) {
                if (temp < integers.get(i) * 2) {
                    isTwice = false;
                }
            }
            if (!isTwice) {
                return -1;
            } else {
                return maxNum;
            }
        }
    }
}
