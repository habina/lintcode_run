package com.google.phone;

import java.util.Arrays;

public class SearchRange {
    
    public static int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true, 0, nums.length - 1);
        int right = binarySearch(nums, target, false, 0, nums.length - 1);
        
        int[] res = new int[2];
        res[0] = left;
        res[1] = right;
        return res;
    }
    
    public static int binarySearch(int[] a, int target, boolean dir, int start, int end) {
        if (start + 1 >= end) {
            if (a[start] == target && a[end] == target) {
                if (dir) {
                    return start;
                } else {
                    return end;
                }
            } else if (a[start] == target) {
                return start;
            } else if (a[end] == target) {
                return end;
            } else {
                return -1;
            }
        }
        int mid = start + (end - start) / 2;
        
        if (a[mid] == target) {
            if (dir) {
                return binarySearch(a, target, dir, start, mid);
            } else {
                return binarySearch(a, target, dir, mid, end);
            }
        } else if (a[mid] < target) {
            return binarySearch(a, target, dir, mid, end);
        } else {
            return binarySearch(a, target, dir, start, mid);
        }
    }

    public static void main(String[] args) {
        int[] a = { 5, 7, 7, 8, 8, 10 };
        System.out.println(Arrays.toString(searchRange(a, 8)));
    }

}
