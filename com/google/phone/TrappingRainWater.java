package com.google.phone;

public class TrappingRainWater {

    /**
     * @param heights:
     *            an array of integers
     * @return: a integer
     */
    public static int trapRainWater(int[] heights) {
        // runtime: n
        // space: n
        if (heights.length == 0) {
            return 0;
        }
        int[] left = new int[heights.length];
        left[0] = heights[0];
        int[] right = new int[heights.length];
        right[heights.length - 1] = heights[heights.length - 1];
        int res = 0;
        // find max height from left side
        for (int i = 1; i < heights.length; i++) {
            left[i] = Math.max(left[i - 1], heights[i]);
        }
        // find max height from right side
        for (int i = heights.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], heights[i]);
        }

        // when i == 0, it can't trap water
        for (int i = 1; i < heights.length - 1; i++) {
            int water = Math.min(left[i], right[i]) - heights[i];
            if (water > 0) {
                res += water;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = { 100, 0, 100 };
        System.out.println(trapRainWater(a));
    }

}
