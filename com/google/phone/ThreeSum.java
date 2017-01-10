package com.google.phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<List<Integer>> uniqueRes = new HashSet<List<Integer>>();
        
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            List<List<Integer>> pairs = search(nums, i + 1, nums.length - 1, target);
            for (List<Integer> pair : pairs) {
                pair.add(0, nums[i]);
                uniqueRes.add(pair);
            }
        }
        
        res.addAll(uniqueRes);
        return res;
    }
    
    public List<List<Integer>> search(int[] nums, int i, int j, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(nums[i]);
                pair.add(nums[j]);
                res.add(pair);
                j--;
                i++;
            }
        }
        return res;
    }

}
