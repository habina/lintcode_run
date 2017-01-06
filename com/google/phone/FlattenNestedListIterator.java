package com.google.phone;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.google.phone.NestedIterator.NestedInteger;

public class FlattenNestedListIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        } else {
            return -1;
        }
    }

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