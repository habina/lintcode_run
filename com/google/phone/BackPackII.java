package com.google.phone;

public class BackPackII {
    
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // dp[i] stands for max value can hold for size of i backpack
        int[] dp = new int[m + 1];
        dp[0] = 0;
        
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= 1; j--) {
                if (j >= A[i]) {
                    dp[j] = Math.max(dp[j], V[i] + dp[j - A[i]]);
                }
            }
        }
        
        return dp[m];
    }

}
