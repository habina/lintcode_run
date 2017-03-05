package com.facebook.phone;

public class CountAndSay {
    
    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }
    
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String prev = "1";
        int count = 0;
        char say = ' ';
        int seq = 1;
        
        while (seq < n) {
            String next = "";
            count = 1;
            say = prev.charAt(0);
            for (int i = 1; i < prev.length(); i++) {
                if (say == prev.charAt(i)) {
                    count++;
                } else {
                    next += count + "" + say;
                    count = 1;
                    say = prev.charAt(i);
                }
            }
            
            next += count + "" + say;
            prev = next;
            seq++;
        }
        
        return prev;
    }

}
