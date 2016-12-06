package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubarrayIII {

    /**
     * @param nums:
     *            A list of integers
     * @param k:
     *            An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public static int maxSubArray(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }

        // globalMax[k][j] kth partition, first j numbers max subarray sum 
        int[][] global = new int[k + 1][nums.length + 1];

        for (int i = 1; i <= k; i++) {
            int localMax = Integer.MIN_VALUE;
            for (int j = i; j <= nums.length; j++) {
                // localMax include nums[j-1]
                localMax = Math.max(localMax, global[i - 1][j - 1]) + nums[j - 1];
                if (j == i) {
                    global[i][j] = localMax;
                } else {
                    global[i][j] = Math.max(localMax, global[i][j - 1]);
                }
            }
        }
        
        for (int i = 0; i <= k; i++) {
            System.out.println(Arrays.toString(global[i]));
        }

        return global[k][nums.length];
    }

    public static void main(String[] args) {
        int[] a = { -1, 4, -2, 3, -2, 3 };
        System.out.println(maxSubArray(a, 2));
        int[] b = { 1, 2, 3 };
        System.out.println(maxSubArray(b, 1));
        int[] c = { 5, 4 };
        System.out.println(maxSubArray(c, 2));
    }

}
