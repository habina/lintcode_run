package com.google.phone;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        // n * k
//        if (nums.length == 0) {
//            return nums;
//        }
//        int[] res = new int[nums.length - k + 1];
//        
//        for (int i = 0; i < res.length; i++) {
//            int max = Integer.MIN_VALUE;
//            for (int j = 0; j < k; j++) {
//                max = Math.max(max, nums[i + j]);
//            }
//            res[i] = max;
//        }
//        
//        return res;
//    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        // n
        if (nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            // if head index is the most left index in the window, remove it
            // since we are moving to next pos
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            // while tail index element is less than new element, remove it
            // maintain the deque is descending.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offer(i);
            
            if (i + 1 >= k) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return res;
    }

}
