package com.google.phone;

public class OnesAndZeroes {
    
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] stands for number of string can form using i 0s and j 1s
        int[][] dp = new int[m + 1][n + 1];
        
        for (String s : strs) {
            int zeros = 0;
            int ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        
        return dp[m][n];
    }

}
