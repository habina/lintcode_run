package com.google.phone;

public class QuickSelectKthMedianOfTwoSortedArray {

    /**
     * @param A:
     *            An integer array.
     * @param B:
     *            An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public static double findMedianSortedArrays(int[] a, int[] b) {
        // runtime: log(m+n)
        int len = a.length + b.length;
        if (len % 2 == 1) {
            return findKthNumber(a, 0, b, 0, len / 2 + 1);
        } else {
            return (findKthNumber(a, 0, b, 0, len / 2) + findKthNumber(a, 0, b, 0, len / 2 + 1)) / 2.0;
        }
    }

    public static int findKthNumber(int[] a, int aStart, int[] b, int bStart, int k) {
        // ref: https://segmentfault.com/a/1190000005138314
        if (aStart == a.length) {
            return b[bStart + k - 1];
        } else if (bStart == b.length) {
            return a[aStart + k - 1];
        }
        
        if (k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }

        int mid = k / 2 - 1;
        int kNew = k - k / 2;
        int aMid = Integer.MAX_VALUE;
        int bMid = Integer.MAX_VALUE;
        
        if (aStart + mid < a.length) {
            aMid = a[aStart + mid];
        }
        if (bStart + mid < b.length) {
            bMid = b[bStart + mid];
        }
        
        if (aMid < bMid) {
            return findKthNumber(a, aStart + k / 2, b, bStart, kNew);
        } else {
            return findKthNumber(a, aStart, b, bStart + k / 2, kNew);
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6 };
        int[] b = { 2, 3, 4, 5 };
        System.out.println(findMedianSortedArrays(a, b));
    }

}
