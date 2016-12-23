package com.google.phone;

public class WildcardMatching {
    
    // dp version: http://bangbingsyb.blogspot.com/2014/11/leetcode-wildcard-matching.html
    // two pointer version: https://segmentfault.com/a/1190000003786247
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public static boolean isMatch(String s, String p) {
        if (s.isEmpty()) {
            if (p.isEmpty()) {
                return true;
            } else {
                for (int i = 0; i < p.length(); i++) {
                    if (p.charAt(i) != '*') {
                        return false;
                    }
                }
                return true;
            }
        }
        
        if (p.isEmpty()) {
            return false;
        }
        
        if (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(0) == '*') {
            return isMatch(s.substring(1), p)
                || isMatch(s, p.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","aa"));
        System.out.println(isMatch("aaa","aa"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("aab", "c*a*b"));

    }

}
