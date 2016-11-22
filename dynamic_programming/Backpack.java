package dynamic_programming;

import java.util.Arrays;

public class Backpack {
    
    public static int backPack(int m, int[] A) {
        // dp[m] stands for max size of A[0:i) items in size of m backpack
        // 0<=i<=A.length, 0<=j<=m
        // runtime: m*n, space: m

        int[] dp = new int[m + 1];
        dp[0] = 0;

        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= 1; j--) {
                if (j >= A[i - 1]) {
                    dp[j] = Math.max(dp[j], A[i-1] + dp[j - A[i - 1]]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[m];
    }

    /**
     * @param m:
     *            An integer m denotes the size of a backpack
     * @param A:
     *            Given n items with size A[i]
     * @return: The maximum size
     */
//    public static int backPack(int m, int[] A) {
//        // dp[i][j] stands for max size of A[0:i) items in size of j backpack
//        // 0<=i<=A.length, 0<=j<=m
//        // dp[0][0] = 0
//        // dp[0][j] = 0
//        // dp[i][0] = 0
//        // runtime: m*n, space: m*n
//
//        int[][] dp = new int[A.length + 1][m + 1];
//        for (int i = 0; i <= A.length; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 0; j <= m; j++) {
//            dp[0][j] = 0;
//        }
//        
//        for (int i = 1; i <= A.length; i++) {
//            for (int j = m; j >= 1; j--) {
//                if (j < A[i - 1]) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i-1][j], A[i-1] + dp[i - 1][j - A[i - 1]]);
//                }
//            }
//        }
//
//        return dp[A.length][m];
//    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 5, 7 };
        System.out.println(backPack(11, a));
        System.out.println(backPack(12, a));
        int[] b = { 20, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 7, 2, 15, 15, 15, 15 };
        System.out.println(backPack(10, b));
    }

}
