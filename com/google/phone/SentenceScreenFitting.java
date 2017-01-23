package com.google.phone;

public class SentenceScreenFitting {
    
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // ref: http://www.cnblogs.com/grandyang/p/5975426.html
        String len = "";
        for (String s : sentence) {
            len += s + " ";
        }
        
        int start = 0;
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (len.charAt(start % len.length()) == ' ') {
                start++;
            } else {
                while (start > 0 && len.charAt((start - 1) % len.length()) != ' ') {
                    start--;
                }
            }
        }
        
        return start / len.length();
    }

}
