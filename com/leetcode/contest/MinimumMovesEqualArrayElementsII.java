package com.leetcode.contest;

import java.util.Arrays;

public class MinimumMovesEqualArrayElementsII {

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int med = nums[nums.length >>> 1];
        int step = 0;
        
        for (int i = 0; i < nums.length; i++) {
            step += Math.abs((nums[i] - med));
        }
        
        return step;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        System.out.println(minMoves2(a));
    }

}
