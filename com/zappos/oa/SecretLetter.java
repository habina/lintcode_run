package com.zappos.oa;

import java.util.Stack;

public class SecretLetter {
    
    public static String reverse(String reverseMe) {
        char[] array = reverseMe.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        String res = "";
        
        for (char c : array) {
            if (c == ' ') {
                String tmp = "";
                while (!stack.isEmpty()) {
                    tmp += stack.pop();
                }
                res += tmp;
                res += " ";
            } else {
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "Let's meet in the owlery today";
        System.out.println(reverse(s));
    }

}
