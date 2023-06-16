package com.geekaca.text;

import java.util.ArrayList;

public class Text02 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(findSame(nums1));
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(findSame(nums2));
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(findSame(nums3));
    }


    public static boolean findSame(int[] nums) {
        if (nums == null) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}