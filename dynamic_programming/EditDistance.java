package dynamic_programming;

public class EditDistance {
    
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public static int minDistance(String word1, String word2) {
        // dp[i][j] stands for the minimum steps for converting [0:i] to [0:j] exclusive on left bound
        // dp[0][j] takes j steps for converting [0:0] to [0:j]
        
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        int res = Integer.MAX_VALUE;
        // init
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // choose to either delete i or j, see which is smaller, +1 is for delete operation
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    // if not equal, do a replace operation.
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "mart";
        String word2 = "karma";
        System.out.println(minDistance(word1, word2));
        System.out.println(minDistance("park", "spake"));
    }

}
