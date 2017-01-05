package com.google.phone;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        char[] ss = s.toCharArray();
        int max = 0;
        
        for (int i = 0; i < ss.length; i++) {
            if (map.containsKey(ss[i])) {
                map.put(ss[i], map.get(ss[i]) + 1);
            } else {
                map.put(ss[i], 1);
            }
            
            if (map.size() > k) {
                max = Math.max(max, i - start);
                while (map.size() > k) {
                    int count = map.get(ss[start]);
                    if (count == 1) {
                        map.remove(ss[start]);
                    } else {
                        map.put(ss[start], count - 1);
                    }
                    start++;
                }
            }
        }
        
        max = Math.max(max, ss.length - start);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }

}
