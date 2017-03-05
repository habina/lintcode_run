package com.google.phone;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORofTwoNumbers {
    
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num & mask);
            }
            
            int tmp = res | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    res = tmp;
                    break;
                }
            }
        }
        
        return res;
    }

}
