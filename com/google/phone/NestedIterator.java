package com.google.phone;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
   }
    
    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        if (this.hasNext()) {
            return stack.pop().getInteger();
        } else {
            return null;
        }
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            }
            
            List<NestedInteger> lst = stack.pop().getList();
            for (int i = lst.size() - 1; i >= 0; i--) {
                stack.push(lst.get(i));
            }
        }
        
        return false;
    }

    @Override
    public void remove() {
    }
    
}
