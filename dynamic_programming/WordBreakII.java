package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    
    public static List<String> wordBreak(String s, Set<String> wordDict) {

        // dp[i] = true stands for s[0:i) can be break
        // dp[0] = true
        // dp[i] = true iff there exist a 0<=k<i s[0:k) and s[k:i) in dict and dp[k] == true
        
        HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxLength = Integer.MIN_VALUE;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = false;
            for (int k = 0; k < i; k++) {
                if (i - k > maxLength) {
                    continue;
                }
                
                String sub = s.substring(k, i);
                if (dp[k] && wordDict.contains(sub)) {
                    if (map.containsKey(i)) {
                        map.get(i).add(sub);
                    } else {
                        List<String> temp = new ArrayList<String>();
                        temp.add(sub);
                        map.put(i, temp);
                    }
                    dp[i] = true;
                }
            }
        }

        List<String> res = new ArrayList<String>();
        if (map.containsKey(s.length())) {
            dfs(res, map, s.length(), "");
        }
        return res;
    }
    
    public static void dfs(List<String> res, HashMap<Integer, List<String>> map, int key, String cur) {
        if (key == 0) {
            res.add(cur.trim());
            return;
        }
        
        for (String word : map.get(key)) {
            String combined = word + " " + cur;
            // use the word length to the prev step
            dfs(res, map, key - word.length(), combined);
        }
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(wordBreak("catsanddog", dict));
    }

}
