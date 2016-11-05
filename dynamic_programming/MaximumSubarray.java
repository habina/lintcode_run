package dynamic_programming;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        // dp[i] stands for maximum sum at index i
        
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 2, -3, 4, -1, 2, 1, -5, 3 };
        System.out.println(maxSubArray(nums));
    }

}
