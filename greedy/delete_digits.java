package greedy;

import java.util.Stack;

public class delete_digits {
    
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public static String DeleteDigits(String A, int k) {
        // runtime: n + k
        // find first position that is decreasing from left to right
        Stack<Integer> stack = new Stack<Integer>();
        int deleted = 0;
        
        for (int i = 0; i < A.length(); i++) {
            int curDigit = A.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > curDigit && deleted < k) {
                deleted++;
                stack.pop();
            }
            stack.push(curDigit);
        }
        
        while (deleted < k) {
            deleted++;
            stack.pop();
        }
        
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb = sb.deleteCharAt(0);
        }
        
        return sb.toString(); 
    }

    public static void main(String[] args) {
        System.out.println(DeleteDigits("178542", 4));
    }

}
