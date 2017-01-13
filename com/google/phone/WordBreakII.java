package com.google.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        // dp[i] = true iff exist k such that s[0:k), s[k:i) are in dict, and
        // dp[k]

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // a graph, {index : list of string that s[0:i) can be break into}
        Map<Integer, List<String>> g = new HashMap<Integer, List<String>>();
        // find max length for prune
        int maxLength = Integer.MIN_VALUE;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }

        for (int i = 1; i < dp.length; i++) {
            for (int k = i - 1; k >= 0; k--) {
                if (i - k > maxLength) {
                    break;
                }

                String sub = s.substring(k, i);
                if (dp[k] && wordDict.contains(sub)) {
                    // build the graph
                    if (g.containsKey(i)) {
                        g.get(i).add(sub);
                    } else {
                        List<String> t = new ArrayList<String>();
                        t.add(sub);
                        g.put(i, t);
                    }
                    dp[i] = true;
                }
            }
        }

        List<String> res = new ArrayList<String>();
        // contains means there at least one path
        if (g.containsKey(s.length())) {
            dfs(res, "", s.length(), g);
        }

        return res;
    }

    public static void dfs(List<String> res, String cur, int key, Map<Integer, List<String>> g) {
        if (key == 0) {
            res.add(cur.trim());
            return;
        }

        for (String prev : g.get(key)) {
            String path = prev + " " + cur;
            dfs(res, path, key - prev.length(), g);
        }
    }
    
    public static void main(String[] args) {
        List<String> dict = new ArrayList<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(wordBreak("catsanddog", dict));
    }

}
