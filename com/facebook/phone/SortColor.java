package com.facebook.phone;

public class SortColor {
    
    public static void main(String[] args) {
        int[] nums = {2,0,0,1,2,0,2};
        sortColors(nums);
    }

    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        
        while (cur <= right) {
            if (nums[cur] == 0) {
                // swap to left
                swap(nums, cur, left);
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                // swap to right
                swap(nums, cur, right);
                right--;
            } else {
                // skip 1
                cur++;
            }
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
