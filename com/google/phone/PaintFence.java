package com.google.phone;

public class PaintFence {
    
    public static int numWays(int n, int k) {
        // dp[i] stands for number of ways to paint at ith pos
        // using rolling array
        int[] dp = {0, k, k * k, 0};
        if (n <= 2) {
            return dp[n];
        }
        for (int i = 3; i <= n; i++) {
            // diff color with i - 1, k - 1 for diff with i-1 pos
            dp[3] = (k - 1) * dp[2];
            // same color with i - 1, k - 1 for diff with i-2 pos
            dp[3] += (k - 1) * dp[1];
            
            // shift element to right
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        
        return dp[3];
    }

}
