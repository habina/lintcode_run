package com.google.phone;

import java.util.Arrays;

public class WiggleSort {
    
    /**
     * @param nums a list of integer
     * @return void
     */
    public static void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] n = {3, 5, 2, 1, 6, 4};
        wiggleSort(n);
        System.out.println(Arrays.toString(n));
    }

}
