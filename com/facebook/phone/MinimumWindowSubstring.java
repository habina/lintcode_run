package com.facebook.phone;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if (target.length() > source.length()) {
            return "";
        }

        // { character : frequence of character }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int found = 0;
        int minLen = source.length() + 1;
        String res = "";
        // init map
        for (int i = 0; i < target.length(); i++) {
            char key = target.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        
        // traverse source
        for (int right = 0; right < source.length(); right++) {
            char key = source.charAt(right);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) >= 0) {
                    found++;
                }
                
                while (found == target.length()) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        res = source.substring(left, right + 1);
                    }
                    char leftKey = source.charAt(left);
                    if (map.containsKey(leftKey)) {
                        map.put(leftKey, map.get(leftKey) + 1);
                        if (map.get(leftKey) > 0) {
                            found--;
                        }
                    }
                    left++;
                }
            }
        }
        
        return res;
    }

}
