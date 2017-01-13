package com.google.phone;

public class LongestIncreasingPathMatrix {
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        // dp[i][j] stands for longest increasing path at (i, j)
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 1;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res = Math.max(res, dfs(dp, matrix, i, j));
            }
        }
        
        return res;
    }
    
    public int dfs(int[][] dp, int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int maxLength = 1;
        
        for (int z = 0; z < dx.length; z++) {
            int x = i + dx[z];
            int y = j + dy[z];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length) {
                continue;
            }
            if (matrix[x][y] > matrix[i][j]) {
                int newLength = 1 + dfs(dp, matrix, x, y);
                maxLength = Math.max(maxLength, newLength);
            }
        }

        dp[i][j] = maxLength;
        return maxLength;
    }

}
