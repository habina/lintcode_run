package data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DataStreamMedian {

    /**
     * @param nums:
     *            A list of integers.
     * @return: the median of numbers
     */
    public static int[] medianII(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 0) {
            return res;
        }
        // store larger half elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // store smaller half elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            
            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                // need swap, since maxHeap keeps smaller half elements
                if (minHeap.peek() < maxHeap.peek()) {
                    int max = maxHeap.poll();
                    int min = minHeap.poll();
                    maxHeap.offer(min);
                    minHeap.offer(max);
                }
            }

            if (minHeap.size() == maxHeap.size()) {
                // or (minHeap.peek() + maxHeap.peek()) / 2
                res[i] = maxHeap.peek();
            } else {
                res[i] = maxHeap.peek();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] n = { 1, 2, 3, 4, 5 };
        int[] res = medianII(n);
        for (int i : res) {
            System.out.println(i);
        }
    }

}
