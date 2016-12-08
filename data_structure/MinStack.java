package data_structure;

import java.util.Stack;

public class MinStack {
    
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MinStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int number) {
        stack1.push(number);
        if (stack2.isEmpty()) {
            stack2.push(number);
        } else {
            if (stack2.peek() < number) {
                stack2.push(stack2.peek());
            } else {
                stack2.push(number);
            }
        }
    }

    public int pop() {
        stack2.pop();
        return stack1.pop();
    }

    public int min() {
        return stack2.peek();
    }
}
