package com.google.phone;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    
    public static int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        Stack<String> stack = new Stack<String>();
        int max = 0;
        int length = 0;
        int curLevel = 0;
        
        for (int i = 0; i < parts.length; i++) {
            int nextLevel = getLevel(parts[i]);
            while (!stack.isEmpty() && curLevel >= nextLevel) {
                String t = stack.pop();
                length -= t.replace("\t", "").length();
                if (isDir(t)) {
                    length -= 1;
                }
                curLevel--;
            }
            stack.push(parts[i]);
            length += parts[i].replace("\t", "").length();
            if (isDir(parts[i])) {
                // add 1 for /
                length += 1;
            } else {
                max = Math.max(max, length);
            }
            curLevel = nextLevel;
        }

        return max;
    }
    
    public static boolean isDir(String s) {
        return s.split("\\.").length == 1;
    }
    
    public static int getLevel(String s) {
        return s.length() - s.replace("\t", "").length();
    }

    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

}
