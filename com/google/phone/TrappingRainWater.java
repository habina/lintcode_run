package com.google.phone;

import java.util.Stack;

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
    
//    public static int trap(int[] height) {
//        Stack<Integer> stack = new Stack<Integer>();
//        if (height.length < 2) {
//            return 0;
//        }
//        stack.push(0);
//        int total = 0;
//        
//        for (int i = 1; i < height.length; i++) {
//            if (height[i] > height[stack.peek()]) {
//                int bottomHeight = height[stack.pop()];
//                // while left is the bottleneck
//                while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
//                    int leftIndex = stack.pop();
//                    int leftHeight = height[leftIndex];
//                    total += (leftHeight - bottomHeight) * (i - leftIndex - 1);
//                    bottomHeight = leftHeight;
//                }
//                // right is the bottleneck
//                if (!stack.isEmpty()) {
//                    total += (height[i] - bottomHeight) * (i - stack.peek() - 1);
//                }
//            }
//            stack.push(i);
//        }
//
//        return total;
//    }

    public static void main(String[] args) {
        int[] a = { 0,1,0,2,1,0,1,3,2,1,2,1 };
//        System.out.println(trap(a));
        System.out.println(trapRainWater(a));
    }

}
