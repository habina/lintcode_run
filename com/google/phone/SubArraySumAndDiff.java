package com.google.phone;


public class SubArraySumAndDiff {
    
    public static int sumEqual(int[] a) {
        int i = 0;
        int j = a.length - 1;
        int leftSum = a[i];
        int rightSum = a[j];
        
        while (i < j) {
            if (leftSum == rightSum) {
                if (j - i == 2) {
                    return i + 1;
                } else {
                    i++;
                    leftSum += a[i];
                }
            } else if (leftSum < rightSum) {
                i++;
                leftSum += a[i];
            } else if (rightSum < leftSum){
                j--;
                rightSum += a[j];
            }
        }
        
        return -1;
    }
    
    public static int dpMinDiff(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        
        // dp[i][j] = 1 if sum of a[0:i] (include or exclude i) equal = j
        int[][] dp = new int[a.length + 1][sum + 1];
        // init
        for (int i = 0; i <= a.length; i++) {
            // sum to 0 is possible for all elements
            dp[i][0] = 1;
        }
        for (int j = 1; j <= sum; j++) {
            // with 0 elements, no other sum except 0 is possible
            dp[0][j] = 0;
        }
        
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= sum; j++) {
                // if ith element is excluded
                dp[i][j] = dp[i - 1][j];
                
                // if ith element is included
                // j has to have enough capacity to take a[i - 1]
                if (a[i-1] <= j) {
                    dp[i][j] |= dp[i-1][j-a[i-1]];
                }
            }
        }
        
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[a.length][j] == 1) {
                diff = sum - 2 * j;
                break;
            }
        }
        
        return diff;
    }

    public static int dp1DMinDiff(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        
        // dp[j] = 1 if elements in a sum to j is possible
        int[] dp = new int[sum + 1];
        // init
        dp[0] = 1;
        
        for (int i = 1; i <= a.length; i++) {
            for (int j = sum; j >= 1; j--) {
                // if ith element is excluded
                if (a[i-1] <= j) {
                    dp[j] |= dp[j - a[i - 1]];
                }
            }
        }
        
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[j] == 1) {
                diff = sum - 2 * j;
                break;
            }
        }
        
        return diff;
    }
    
    public static int minDiff(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        
        return helper(a, a.length, 0, sum);
    }
    
    public static int helper(int[] a, int i, int soFar, int total) {
        if (i == 0) {
            return Math.abs((total - soFar) - soFar);
        }
        
        return Math.min(helper(a, i - 1, soFar + a[i - 1], total), helper(a, i - 1, soFar, total));
    }

    public static void main(String[] args) {
        int[] a = { 1, 8, 2, 7, 1, 3, 6, 9 };
        System.out.println(sumEqual(a));
        System.out.println(minDiff(a));
        System.out.println(dpMinDiff(a));
        System.out.println(dp1DMinDiff(a));
    }

}
