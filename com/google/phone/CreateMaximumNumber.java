package com.google.phone;

import java.util.Arrays;
import java.util.Stack;

public class CreateMaximumNumber {
    
    /**
     * @param nums1 an integer array of length m with digits 0-9
     * @param nums2 an integer array of length n with digits 0-9
     * @param k an integer and k <= m + n
     * @return an integer array
     */
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // (m+n)^3
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        
//        int max = m >= k ? k : m;
//        int min = n >= k ? 0 : k - n;
//        if n < k, you can take at most n elements from nums2
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] res1 = getMaxArray(nums1, i);
            int[] res2 = getMaxArray(nums2, k - i);
            int[] merged = merge(res1, res2);
            if (isSmaller(res, 0, merged, 0)) {
                res = merged;
            }
        }

        return res;
    }
    
    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < a.length && j < b.length) {
            // isSmaller is for if a[i] == b[j]
            // need to compare the rest elements, to define a larger to take
            if (isSmaller(a, i, b, j)) {
                res[count] = b[j];
                j++;
            } else {
                res[count] = a[i];
                i++;
            }
            count++;
        }
        
        while (i < a.length) {
            res[count] = a[i];
            i++;
            count++;
        }
        while (j < b.length) {
            res[count] = b[j];
            j++;
            count++;
        }
        
        return res;
    }
    
    // return true if a is smaller than b
    public static boolean isSmaller(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                return true;
            } else if (a[i] > b[j]){
                return false;
            } else {
                i++;
                j++;
            }
        }
        return i == a.length;
    }
    
    public static int[] getMaxArray(int[] a, int k) {
        int[] res = new int[k];
        int drop = a.length - k;
        Stack<Integer> stack = new Stack<Integer>();
        for (int num : a) {
            while (drop != 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                drop--;
            }
            stack.push(num);
        }
        while (drop != 0) {
            stack.pop();
            drop--;
        }

        int i = Math.max(0, k - 1);
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i--;
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] res = maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(res));
    }

}
