package com.google.phone;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                res.add(lower + "");
            } else {
                res.add(lower + "->" + upper);
            }
            return res;
        }
        int cur = 0;
        int i = lower;
        while (i <= upper && cur < nums.length) {
            if (i < nums[cur]) {
                if (i + 1 == nums[cur]) {
                    res.add(i + "");
                } else {
                    res.add(i + "->" + (nums[cur] - 1));
                }
                if (nums[cur] == Integer.MAX_VALUE) {
                    break;
                }
            }
            i = nums[cur] + 1;
            cur++;
        }

        if (i > nums[nums.length - 1]) {
            if (i == upper) {
                res.add(i + "");
            } else if (i < upper) {
                res.add(i + "->" + upper);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = { 0, 1, 3, 50, 75 };
        System.out.println(findMissingRanges(a, 0, 99));
    }

}
