package dynamic_programming;

public class DistinctSubsequences {
    
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public static int numDistinct(String S, String T) {
        // dp[i][j] stands for number of distinct subsequence between s[0:i), t[0:j), inclusive
        // dp[0][j] = 0, s is empty string, so no subsequence in s matches T
        // dp[i][0] = 1, t is empty string, so only one subsequence in s matches T
        
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        // both are empty string
        dp[0][0] = 1;
        // T is empty
        for (int i = 1; i <= S.length(); i++) {
            dp[i][0] = 1;
        }
        // S is empty
        for (int j = 1; j <= T.length(); j++) {
            dp[0][j] = 0;
        }
        
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                // dp[i][j] = dp[i - 1][j], for same amount of j, at least dp[i - 1][j] distinct subsq
                dp[i][j] = dp[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[S.length()][T.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

}
