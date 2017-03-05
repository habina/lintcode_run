package com.facebook.phone;

public class ValidPalindrome {
    
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();
        int begin = 0;
        int end = s.length() - 1;
        
        while (true) {
            while (begin < s.length() && !isValid(s.charAt(begin))) {
                begin++;
            }
            
            while (end >= 0 && !isValid(s.charAt(end))) {
                end--;
            }
            
            if (begin > end) {
                break;
            }

            if (s.charAt(begin) == s.charAt(end)) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

}
