package com.google.phone;

public class RegularExpressionMatching {
    
    public static boolean isMatch(String s, String p) {
        if (s.isEmpty()) {
            if (p.isEmpty()) {
                return true;
            } else if (p.length() >= 2) {
                // check if p represents an empty string
                if (p.length() % 2 != 0) {
                    // .* needs to be pair
                    return false;
                }
                for (int i = 1; i < p.length(); i+=2) {
                    if (p.charAt(i) != '*') {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else if (p.isEmpty()) {
            return false;
        }
        
        // match 1 pos
        if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
            // if the next pos is *
            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2))
                    || isMatch(s.substring(1), p);
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        } else if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2));
        } else {
            return false;
        }
    }

    /**
     * @param s:
     *            A string
     * @param p:
     *            A string includes "." and "*"
     * @return: A boolean
     */
//    public static boolean isMatch(String s, String p) {
//        // runtime: 2^n
//        // ref: dp version https://segmentfault.com/a/1190000003904286
//        if (s.isEmpty()) {
//            if (p.isEmpty()) {
//                return true;
//            } else if (p.length() >= 2) {
//                // check if p represents an empty string
//                if (p.length() % 2 != 0) {
//                    return false;
//                }
//                for (int i = 1; i < p.length(); i+=2) {
//                    if (p.charAt(i) != '*') {
//                        return false;
//                    }
//                }
//                return true;
//            } else {
//                return false;
//            }
//        }
//        if (p.isEmpty()) {
//            return false;
//        }
//        
//        if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
//            if (p.length() > 1 && p.charAt(1) == '*') {
//                return isMatch(s, p.substring(2))
//                    || isMatch(s.substring(1), p);
//            } else {
//                return isMatch(s.substring(1), p.substring(1));
//            }
//        } else if (p.length() > 1 && p.charAt(1) == '*'){
//            return isMatch(s, p.substring(2));
//        }
//        return false;
//    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aaa", "aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", ".*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
    }

}
