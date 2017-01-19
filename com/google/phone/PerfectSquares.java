package com.google.phone;

import java.util.Arrays;

public class PerfectSquares {
    
    public int numSquares(int n) {
        // dp[i] stands for the minimum number of squares to sum to i
        int[] dp = new int[n + 1];
        // init all pos to be MAX VALUE
        Arrays.fill(dp, Integer.MAX_VALUE);
        // init all i*i pos to be 1
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        
        int min = Integer.MAX_VALUE;
        // n = a + x * x
        for (int a = 1; a <= n; a++) {
            for (int x = 1; a + x * x <= n; x++) {
                dp[a + x * x] = Math.min(dp[a + x * x], dp[a] + 1);
            }
        }
        
        return dp[n];
    }

}
