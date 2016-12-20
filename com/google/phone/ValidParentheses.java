package com.google.phone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> open = new HashMap<Character, Character>();
        open.put('(', ')');
        open.put('{', '}');
        open.put('[', ']');
        Set<Character> close = new HashSet<Character>();
        close.add(')');
        close.add('}');
        close.add(']');
        
        for (int i = 0; i < s.length(); i++) {
            if (open.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (close.contains(s.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                char o = stack.pop();
                if (open.get(o) != s.charAt(i)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

}
