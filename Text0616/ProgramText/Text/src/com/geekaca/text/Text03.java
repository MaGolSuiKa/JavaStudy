package com.geekaca.text;

public class Text03 {
    public static void main(String[] args) {
        int[] nums = {34, 23, 56, 99, -2};
        System.out.println("最大值为" + findMax(nums));
    }

    public static int findMax(int[] nums) {
        if(nums == null){
            return 0;
        }
        int temp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (temp < nums[i]) {
                temp = nums[i];
            }
        }
        return temp;
    }
}
