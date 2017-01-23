package com.google.phone;

import java.util.Arrays;

public class ThreeSumSmaller {
    
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        
        for(int i = 0; i < nums.length - 2; i++) {
            int fixed = i;
            int start = i + 1;
            int end = nums.length - 1;
            
            while (start + 1 <= end) {
                int val = nums[fixed] + nums[start] + nums[end];
                if (val < target) {
                    // since val is less than target
                    // this means all end within nums[start+1:end-1] will be smaller too
                    res += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return res;
    }

}
