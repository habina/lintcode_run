package dynamic_programming;

public class ClimbingStairs {
    
    /**
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs(int n) {
        // dp[i] stands for number of ways to climb to i
        // dp[0] = 1
        // dp[1] = 1
        // dp[2] = 2
        // dp[3] = 3
        // dp[4] = 5
        
        if (n == 0) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}
