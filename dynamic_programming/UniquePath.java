package dynamic_programming;

public class UniquePath {
    
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public static int uniquePaths(int m, int n) {
        // runtime: n * m
        // dp way, dp[i][j] stands for unique path at (i, j)
        // dp[0][j] or dp[i][0] only has 1 unique path
        // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
      
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

}
