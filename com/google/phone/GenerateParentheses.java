package com.google.phone;

import java.util.ArrayList;

public class GenerateParentheses {
    
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        dfs(res, n, n, "");
        return res;
    }
    
    public static void dfs(ArrayList<String> res, int open, int close, String cur) {
        if (open > close) {
            return;
        }
        if (open == 0 && close == 0) {
            res.add(cur);
            return;
        }
        if (open > 0) {
            dfs(res, open - 1, close, cur + "(");
        }
        if (close > 0) {
            dfs(res, open, close - 1, cur + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
