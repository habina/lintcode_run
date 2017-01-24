package com.google.phone;

public class SplitArrayLargestSum {
    
    public int splitArray(int[] nums, int m) {
        // ref: http://www.cnblogs.com/grandyang/p/5933787.html
        // max element in nums
        int low = 0;
        // sum of all elements in nums
        int high = 0;
        // result is guanrantee to be within [low:high]
        for (int i : nums) {
            low = Math.max(low, i);
            high += i;
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, m, mid)) {
                // mid is too larger
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    // return false if count is larger than m
    // return false mean our mid(maxSum) is too smaller
    public boolean canSplit(int[] nums, int m, int maxSum) {
        int count = 1;
        int curSum = 0;
        for (int i : nums) {
            curSum += i;
            if (curSum > maxSum) {
                // reset curSum to a new partition
                curSum = i;
                // increment the count of number of partition
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        
        return true;
    }

}
