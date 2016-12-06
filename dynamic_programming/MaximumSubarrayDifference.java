package dynamic_programming;

import java.util.Arrays;

public class MaximumSubarrayDifference {

    /**
     * @param nums:
     *            A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public static int maxDiffSubArrays(int[] nums) {
        // leftMax[i] stands for max subarray sum in nums[0:i]
        int[] leftMax = new int[nums.length];
        leftMax[0] = nums[0];
        int[] leftMin = new int[nums.length];
        leftMin[0] = nums[0];

        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        int[] rightMin = new int[nums.length];
        rightMin[nums.length - 1] = nums[nums.length - 1];

        int maxCurSum = nums[0];
        int minCurSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCurSum = Math.max(nums[i], maxCurSum + nums[i]);
            leftMax[i] = Math.max(maxCurSum, leftMax[i - 1]);

            minCurSum = Math.min(nums[i], minCurSum + nums[i]);
            leftMin[i] = Math.min(minCurSum, leftMin[i - 1]);
        }

        maxCurSum = nums[nums.length - 1];
        minCurSum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            maxCurSum = Math.max(nums[i], maxCurSum + nums[i]);
            rightMax[i] = Math.max(maxCurSum, rightMax[i + 1]);

            minCurSum = Math.min(nums[i], minCurSum + nums[i]);
            rightMin[i] = Math.min(minCurSum, rightMin[i + 1]);
        }

        // System.out.println(Arrays.toString(leftMax));
        // System.out.println(Arrays.toString(rightMin));
        //
        // System.out.println(Arrays.toString(leftMin));
        // System.out.println(Arrays.toString(rightMax));

        int diff = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            diff = Math.max(diff, Math.abs(leftMax[i] - rightMin[i + 1]));
            diff = Math.max(diff, Math.abs(leftMin[i] - rightMax[i + 1]));
        }

        return diff;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, -3, 1 };
        System.out.println(maxDiffSubArrays(nums));
    }

}
