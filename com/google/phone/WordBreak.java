package com.google.phone;

import java.util.List;

public class WordBreak {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] = true, iff there exist a k such  that s[0:k), s[k, i) are in dict and dp[k]
        // dp[i] = true if s[0:i) can be break
        // dp[0] = true
        
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
                // pruning
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
