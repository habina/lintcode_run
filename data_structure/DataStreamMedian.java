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
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                minHeap.offer(nums[i]);
            } else {
                maxHeap.offer(nums[i]);
            }

            if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() < minHeap.peek()) {
                int max = maxHeap.poll();
                int min = minHeap.poll();
                minHeap.offer(max);
                maxHeap.offer(min);
            }

            if (minHeap.size() == maxHeap.size()) {
                // or (minHeap.peek() + maxHeap.peek()) / 2
                res[i] = minHeap.peek();
            } else {
                res[i] = minHeap.peek();
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
