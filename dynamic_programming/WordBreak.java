package dynamic_programming;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public static boolean wordBreak(String s, Set<String> dict) {
        // dp[i] = true stands for s[0:i) can be break, otherwise = false
        // dp[0] = true
        // dp[i] = true iff there exist a k such that s[0:k) and s[k:i) are in dict
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxLength = Integer.MIN_VALUE;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = false;
            for (int k = i - 1; k >= 0; k--) {
                if (i - k > maxLength) {
                    break;
                }

                if (dp[k] && dict.contains(s.substring(k, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("lint");
        dict.add("code");
        System.out.println(wordBreak("lintcode", dict));
    }

}
