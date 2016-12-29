package com.google.phone;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {
    
    public static int quickSelect(int[] a, int k) {
        int[] copy = Arrays.copyOf(a, a.length);
        return quickSelect(copy, 0, a.length - 1, k - 1);
    }
    
    public static int quickSelect(int[] a, int start, int end, int k) {
        // in place quick select
        // Time Complexity: average = O(n log n); worse O(n^2)
        // ref: http://www.geekviewpoint.com/java/search/quickselect
        if (start <= end) {
            int pivot = partition(a, start, end);
            if (pivot == k) {
                return a[k];
            } else if (pivot < k) {
                return quickSelect(a, pivot + 1, end, k);
            } else {
                return quickSelect(a, start, pivot - 1, k);
            }
        }
        return Integer.MIN_VALUE;
    }
    
    public static int partition(int[] a, int start, int end) {
        int pivot = start + new Random().nextInt(end - start + 1);
        swap(a, end, pivot);
        for (int i = start; i < end; i++) {
            // a[end] in this case is actually a[pivot], because line 19
            if (a[i] > a[end]) {
                // if current number is larger than pivot
                // put it in front
                swap(a, i, start);
                // Increment start
                start++;
            }
        }
        // swap the pivot on the last start pos
        swap(a, start, end);
        // return the current pivot index, after partition
        return start;
    }
    
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 3, 4};
        for (int i = 1; i <= a.length; i++) {
            System.out.println(quickSelect(a, i));
        }
    }

}
