package com.google.phone;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        boolean[] visited = new boolean[256];
        int[] count = new int[256];
        
        // dummy push for easier comparison
        stack.push('0');
        
        // do count
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        
        // traverse s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]--;
            if (visited[c]) {
                continue;
            }
            
            // compare current with stack top
            // if c less than top, and count[top] > 0
            // this means, top will appear in the future,
            // and c should be placed before top
            while (c < stack.peek() && count[stack.peek()] > 0) {
                // unvisited the top spot
                visited[stack.peek()] = false;
                stack.pop();
            }
            
            // add c to answer set
            stack.push(c);
            visited[c] = true;
        }
        
        String res = "";
        while (stack.size() > 1) {
            res = stack.pop() + res;
        }
        
        return res;
    }

}
