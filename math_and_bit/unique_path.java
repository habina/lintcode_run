package math_and_bit;

public class unique_path {

    /**
     * @param n,
     *            m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public static int uniquePaths(int m, int n) {
        // runtime: n * m
        // dp way, dp[i][j] stands for unique path at (i, j)
        // dp[0][j] or dp[i][0] only has 1 unique path
        // dp[i][j] = dp[i - 1][n] + dp[i][j - 1]
        
        // declare array.
        int[][] dp = new int[m][];
        for (int i = 0; i < m; i++) {
            dp[i] = new int[n];
        }
        
        // initialize array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        
        // computing
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    // runtime: n, slower than dp in computation.
//    /**
//     * @param n,
//     *            m: positive integer (1 <= n ,m <= 100)
//     * @return an integer
//     */
//    public static int uniquePaths(int m, int n) {
//        long res = 1;
//        for (int i = n; i < (m + n - 1); i++) {
//            res *= i;
//            res /= (i - n + 1);
//        }
//        return (int) res;
//    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }

}
