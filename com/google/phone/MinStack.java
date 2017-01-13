package com.google.phone;

import java.util.Stack;

public class MinStack {
    
    Stack<Integer> min;
    Stack<Integer> cur;

    /** initialize your data structure here. */
    public MinStack() {
        min = new Stack<Integer>();
        cur = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (cur.isEmpty()) {
            cur.push(x);
            min.push(x);
        } else {
            cur.push(x);
            min.push(Math.min(x, min.peek()));
        }
    }
    
    public void pop() {
        cur.pop();
        min.pop();
    }
    
    public int top() {
        return cur.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}