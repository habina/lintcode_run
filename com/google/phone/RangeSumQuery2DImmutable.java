package com.google.phone;

import java.util.Arrays;

public class RangeSumQuery2DImmutable {

    int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        // dp[i][j] stands for sum from (0, 0) to (i, j) inclusive
        if (matrix.length == 0) {
            dp = new int[1][1];
        } else {
            dp = new int[matrix.length + 1][matrix[0].length + 1];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = matrix[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
//        System.out.println(dp[row2+1][col2+1]);
//        System.out.println(dp[row2 + 1][col1]);
//        System.out.println(dp[row1][col2 + 1]);
//        System.out.println(dp[row1][col1]);
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
    public static void test2() {
        int[][] a = {{-4, -5}};
        RangeSumQuery2DImmutable b = new RangeSumQuery2DImmutable(a);
        System.out.println(b.sumRegion(0, 0, 0, 0));
        System.out.println(b.sumRegion(0, 0, 0, 1));
        System.out.println(b.sumRegion(0, 1, 0, 1));
    }
    
    public static void test1() {
        int[][] a = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };
        RangeSumQuery2DImmutable b = new RangeSumQuery2DImmutable(a);
        System.out.println(b.sumRegion(2, 1, 4, 3));
        System.out.println(b.sumRegion(1, 1, 2, 2));
        System.out.println(b.sumRegion(1, 2, 2, 4));
    }


}
