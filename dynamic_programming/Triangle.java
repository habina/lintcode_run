package dynamic_programming;

public class Triangle {

    /**
     * @param triangle:
     *            a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public static int minimumTotal(int[][] triangle) {
        // dp[i][j] stands for minimum path sum from triangle[i][j] to the bottom
        // dp[i] stands for minimum path sum from current row with index i to the bottom at triangle[n - 1][i]
        if (triangle.length == 0) {
            return 0;
        }

        // init
        int[] dp = new int[triangle.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle[dp.length - 1][i];
        }
        
        // starting from second row from bottom
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] triangle = new int[3][];
//        triangle[0] = new int[] { 2 };
//        triangle[1] = new int[] { 3, 4 };
//        triangle[2] = new int[] { 6, 5, 7 };
//        triangle[3] = new int[] { 4, 1, 8, 3 };

        triangle[0] = new int[] { -1 };
        triangle[1] = new int[] { 2, 3 };
        triangle[2] = new int[] { 1, -1, -3 };
        System.out.println(minimumTotal(triangle));
    }

}
