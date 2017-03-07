package com.facebook.phone;

public class MinimumSizeSubarraySum {
    
    public int minimumSize(int[] nums, int s) {
        int left = 0;
        int right = 0;
        int size = nums.length + 1;
        int sum = 0;
        
        while (right < nums.length) {
            while (sum < s && right < nums.length) {
                sum += nums[right];
                right++;
            }
            
            while (sum >= s && left < nums.length) {
                size = Math.min(size, right - left);
                sum -= nums[left];
                left++;
            }
        }
        
        if (size == nums.length + 1) {
            return -1;
        } else {
            return size;
        }
    }

}
