package com.google.phone;

import java.util.Arrays;

public class RangeSumQueryImmutable {
    
    int[] nums;
    int[] sums;
    
    public RangeSumQueryImmutable(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
        // sums[i] stands for sum from 0 to ith element inclusive
        this.sums = new int[nums.length + 1];
        this.sums[0] = 0;
        update(0);
    }
    
    void update(int i) {
        for (int k = i + 1; k < this.sums.length; k++) {
            this.sums[k] = this.sums[k - 1] + this.nums[k - 1];
        }
    }

    void update(int i, int val) {
        this.nums[i] = val;
        update(i);
    }

    public int sumRange(int i, int j) {
        return this.sums[j + 1] - this.sums[i];
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        RangeSumQueryImmutable rsq = new RangeSumQueryImmutable(a);
        System.out.println(rsq.sumRange(0, 2));
        rsq.update(1, 2);
        System.out.println(rsq.sumRange(0, 2));
    }

}
