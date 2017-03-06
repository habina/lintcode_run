package com.facebook.phone;

import java.util.List;

public class WordBreak {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] = true iff there exist k such that s[0:k) and s[k:i) are in the dict and dp[k] = true
        // dp[0] = true
        // dp[i] = true stands for s[0:i) can be break
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        // find max length for better pruning
        int maxLength = Integer.MIN_VALUE;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        
        for (int i = 1; i < dp.length; i++) {
            // start with s[i-1, i)
            for (int k = i - 1; k >= 0; k--) {
                // no word length can over maxLength
                if (i - k > maxLength) {
                    break;
                }
                
                if (dp[k]) {
                    String sub = s.substring(k, i);
                    if (wordDict.contains(sub)) {
                        dp[i] = true;
                        break;
                    }
                }
                
            }
        }
        
        return dp[s.length()];
    }

}
