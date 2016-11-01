package com.linkedin.code;

public class HouseRobber {
    
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public static long houseRobber(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        
        if (A.length < 2) {
            return A[0];
        }
        
        if (A.length < 3) {
            return Math.max(A[0], A[1]);
        }
        
        long pPrev = A[0];
        long prev = Math.max(A[0], A[1]);
        long res = 0;
        
        for (int i = 2; i < A.length; i++) {
            long newRes = Math.max(prev, pPrev + A[i]);
            res = Math.max(res, newRes);
            pPrev = prev;
            prev = res;
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] a = {3, 8, 4};
        System.out.println(houseRobber(a));
    }

}
