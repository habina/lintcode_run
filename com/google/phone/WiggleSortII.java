package com.google.phone;

import java.util.Arrays;
import java.util.Random;

public class WiggleSortII {
    
    public static int quickSelect(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);
        if (pivot == k) {
            return nums[pivot];
        } else if (pivot < k) {
            return quickSelect(nums, pivot + 1, end, k);
        } else {
            return quickSelect(nums, start, pivot - 1, k);
        }
    }
    
    public static int partition(int[] nums, int start, int end) {
        int pivot = start + new Random().nextInt(end - start + 1);
        int storeIndex = start;
        // save the pivot to the end pos
        swap(nums, pivot, end);
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                // save anything less than nums[end] before index pivot
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        
        // bring the pivot back to its position
        swap(nums, storeIndex, end);
        return storeIndex;
    }

    /**
     * @param nums a list of integer
     * @return void
     */
    public static void wiggleSort(int[] nums) {
        int median = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
        int[] res = new int[nums.length];
        int s = 0;
        int e = nums.length - 1;
        for (int i = 0; i < res.length; i++) {
            if (nums[i] < median) {
                res[s] = nums[i];
                s++;
            } else if (nums[i] > median) {
                res[e] = nums[i];
                e--;
            }
        }
        
        while (s < nums.length / 2) {
            res[s] = median;
            s++;
        }
        while (e >= nums.length / 2) {
            res[e] = median;
            e--;
        }
        
        // reset s to the middle index.
        s = (nums.length + 1) / 2;
        // reset e to the end
        e = nums.length;
        // pick every other elements from smaller than median and larger than median.
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                s--;
                nums[i] = res[s];
            } else {
                e--;
                nums[i] = res[e];
            }
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] n = {1, 5, 1, 1, 6, 4};
        wiggleSort(n);
        System.out.println(Arrays.toString(n));
    }

}
