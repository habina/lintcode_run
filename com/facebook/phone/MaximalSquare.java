package com.facebook.phone;

public class MaximalSquare {
    
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // dp[i][j] for max side length when m[i][j] as the right lower corner of the square.
        
        if (matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxSide = Integer.MIN_VALUE;
        
        // init dp for column
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = matrix[i][0];
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        // init dp for row
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i];
            maxSide = Math.max(maxSide, dp[0][i]);
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        
        return maxSide * maxSide;
    }

}
