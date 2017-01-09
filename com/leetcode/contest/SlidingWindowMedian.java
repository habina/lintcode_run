package com.leetcode.contest;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        // keeps larger half
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // keeps smaller half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, Collections.reverseOrder());
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            
            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    // swap peek
                    int max = maxHeap.poll();
                    int min = minHeap.poll();
                    maxHeap.offer(min);
                    minHeap.offer(max);
                }
            }
            
            // balance two heap
            while (maxHeap.size() >= minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
            // make sure maxHeap has one more element
            while (minHeap.size() >= maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
            
            if (maxHeap.size() + minHeap.size() == k) {
                if (k % 2 == 0) {
                    res[count] = ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
                } else {
                    res[count] = maxHeap.peek();
                }
                count++;
                int toRemove = nums[i + 1 - k];
                if (toRemove <= maxHeap.peek()) {
                    maxHeap.remove(toRemove);
                } else {
                    minHeap.remove(toRemove);
                }
            }
        }

        return res;
    }

    // public static double[] medianSlidingWindow(int[] nums, int k) {
    // // time limit exceeded version
    // // runtime: nklogk
    // double[] res = new double[nums.length - k + 1];
    //
    // for (int i = 0; i < res.length; i++) {
    // double[] window = new double[k];
    // for (int j = 0; j < k; j++) {
    // window[j] = nums[i + j] * 1.0;
    // }
    // Arrays.sort(window);
    // if (window.length % 2 == 0) {
    // res[i] = (window[k / 2] + window[k / 2 - 1]) / 2.0;
    // } else {
    // res[i] = window[k / 2];
    // }
    // }
    //
    // return res;
    // }

    public static void main(String[] args) {
//        int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int[] a = { 1, 2};
        double[] res = medianSlidingWindow(a, 1);
        System.out.println(Arrays.toString(res));
    }

}
