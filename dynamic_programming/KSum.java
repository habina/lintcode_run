package dynamic_programming;

public class KSum {

    public static int kSum(int A[], int k, int target) {
        // dp version
        // dp[i][j][t] stands for number of cases in A[0:i) selected j numbers which sum is t
        int[][][] dp = new int[A.length + 1][k + 1][target + 1];
        
        for (int i = 0; i <= A.length; i++) {
            dp[i][0][0] = 1;
        }
        
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    if (t - A[i - 1] >= 0) {
                        // take A[i - 1]
                        dp[i][j][t] = dp[i - 1][j - 1][t - A[i - 1]];
                    }
                    // also add the number of cases for don't take A[i - 1]
                    dp[i][j][t] += dp[i - 1][j][t];
                }
            }
        }
        
        return dp[A.length][k][target];
    }

    /**
     * @param A:
     *            an integer array.
     * @param k:
     *            a positive integer (k <= length(A))
     * @param target:
     *            a integer
     * @return an integer
     */
//    public static int kSum(int A[], int k, int target) {
//        // recursive version, but TLE
//        return kSum(A, 0, k, target);
//    }
//
//    public static int kSum(int A[], int i, int k, int target) {
//        if (i >= A.length) {
//            return 0;
//        }
//        
//        if (k <= 0) {
//            return 0;
//        }
//        
//        if (target < 0) {
//            return 0;
//        }
//        
//        int res = 0;
//        if (k == 1) {
//            for (int j = i; j < A.length; j++) {
//                if (A[j] == target) {
//                    res++;
//                }
//            }
//        } else {
//            for (int j = i; j < A.length; j++) {
//                res += kSum(A, j + 1, k - 1, target - A[j]);
//            }
//            
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] a = { 1,3,4,5,8,10,11,12,14,17,20,22,24,25,28,30,31,34,35,37,38,40,42,44,45,48,51,54,56,59,60,61,63,66 };
        System.out.println(kSum(a, 24, 842));
    }

}
