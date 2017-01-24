package com.google.phone;

public class EncodeStringWithShortestLength {
    
    public String encode(String s) {
        // ref: http://www.cnblogs.com/grandyang/p/6194403.html
        if (s == null || s.length() == 0) {
            return "";
        }
        
        // dp[i][j] stands for shortest string from s[i:j]
        String[][] dp = new String[s.length()][s.length()];
        
        for (int step = 0; step < s.length(); step++) {
            for (int start = 0; start + step < s.length(); start++) {
                int end = start + step;
                String subStr = s.substring(start, end + 1);
                // init dp[i][j]
                dp[start][end] = subStr;
                if (step < 4) {
                    continue;
                }
                // find a k between s[start:end] such that dp[start][end] = dp[start][k] + dp[k+1][end] is minimum
                for (int k = start; k < end; k++) {
                    if (dp[start][k].length() + dp[k+1][end].length() < dp[start][end].length()) {
                        dp[start][end] = dp[start][k] + dp[k+1][end];
                    }
                }
                
                // check if subStr has repeat pattern
                for (int k = start; k < end; k++) {
                    // enumerate a repeat pattern
                    String repeat = s.substring(start, k+1);
                    // check if subStr length is multiple of repeat length
                    // check if subStr replace repeat pattern will be an empty string
                    if (subStr.length() % repeat.length() == 0 && subStr.replaceAll(repeat, "").isEmpty()) {
                        String ss = subStr.length() / repeat.length() + "[" + dp[start][k] + "]";
                        if (ss.length() < dp[start][end].length()) {
                            dp[start][end] = ss;
                        }
                    }
                }
            }
        }
        
        return dp[0][s.length() - 1];
        
    }

}
