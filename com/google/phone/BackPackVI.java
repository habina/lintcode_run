package com.google.phone;

public class BackPackVI {
    
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public static int backPackVI(int[] nums, int target) {
        // dp[i] stands for number of choice at target i
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int j = 1; j <= target; j++) {
            for (int n : nums) {
                if (j >= n) {
                    dp[j] += dp[j - n];
                }
            }
        }
        
        return dp[target];
    }

}
