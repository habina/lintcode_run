package com.google.phone;

import java.util.Arrays;

public class RangeSumQueryMutable {

    int[] nums;
    int[] tree;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
        // sums[i] stands for sum from 0 to ith element inclusive
        this.tree = new int[nums.length + 1];
        for (int i = 0; i < this.nums.length; i++) {
            add(i, this.nums[i]);
        }
    }

    int lowerBit(int k) {
        return k & -k;
    }

    int sum(int i) {
        int sum = 0;
        for (int k = i; k > 0; k -= lowerBit(k)) {
            sum += this.tree[k];
        }
        return sum;
    }
    
    void add(int i, int val) {
        for (int k = i + 1; k < this.tree.length; k += lowerBit(k)) {
            this.tree[k] += val;
        }
    }

    void update(int i, int val) {
        int diff = val - this.nums[i];
        add(i, diff);
        this.nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 5 };
        RangeSumQueryMutable rsq = new RangeSumQueryMutable(a);
        System.out.println(rsq.sumRange(0, 2));
        rsq.update(1, 2);
        System.out.println(rsq.sumRange(0, 2));
    }

}
