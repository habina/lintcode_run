package dynamic_programming;

public class UniquePathII {

    /**
     * @param obstacleGrid:
     *            A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[n];
            for (int j = 0; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (i == 0 && j != 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (i != 0 && j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[5][];
        grid[0] = new int[] { 0, 0 };
        grid[1] = new int[] { 0, 0 };
        grid[2] = new int[] { 0, 0 };
        grid[3] = new int[] { 1, 0 };
        grid[4] = new int[] { 0, 0 };
        System.out.println(uniquePathsWithObstacles(grid));
    }

}
