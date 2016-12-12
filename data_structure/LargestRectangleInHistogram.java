package data_structure;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    /**
     * @param height:
     *            A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public static int largestRectangleArea(int[] height) {
        // ref: http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
        if (height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        int[] newHeight = new int[height.length + 1];
        newHeight = Arrays.copyOf(height, newHeight.length);
        
        while (i < newHeight.length) {
            if (stack.isEmpty() || newHeight[stack.peek()] <= newHeight[i]) {
                // saving consecutive increasing numbers
                stack.push(i);
                i++;
            } else {
                // pop until the height[i] >= height[stack.peek()]
                int n = stack.pop();
                if (stack.isEmpty()) {
                    // if stack is empty, newHeight[n] is the smallest rectangle
                    // then there are i rectangles has min newHeight[n]
                    max = Math.max(max, newHeight[n] * i);
                } else {
                    // i - stack.peek() - 1 stands for so far how many rectangle has min newHeight[n]
                    max = Math.max(max, newHeight[n] * (i - stack.peek() - 1));
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(a));
        int[] b = { 1, 1 };
        System.out.println(largestRectangleArea(b));
        int[] c = { 2, 0, 2 };
        System.out.println(largestRectangleArea(c));
    }

}
