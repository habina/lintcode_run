package string;

public class longest_common_substring {

    // DP version, runtime: n * m
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public static int longestCommonSubstring(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }
        // initialize dp array.
        int[][] dp = new int[A.length()][];
        for (int i = 0; i < A.length(); i++) {
            dp[i] = new int[B.length()];
        }
        
        // dp part. dp[i][j] = (a[i] == b[j]) ? dp[i - 1][j - 1] + 1: 0
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                int bit = 0;
                if (A.charAt(i) == B.charAt(j)) {
                    bit = 1;
                    if (i == 0 || j == 0) {
                        dp[i][j] = bit;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + bit;
                    }
                } else {
                    dp[i][j] = 0;
                }
                
                max = Math.max(max, dp[i][j]);
            }
        }
        
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        return max;
    }

//    TLE version, runtime: n * 2 ^ m
//    /**
//     * @param A, B: Two string.
//     * @return: the length of the longest common substring.
//     */
//    public static int longestCommonSubstring(String A, String B) {
//        A = A.toLowerCase();
//        B = B.toLowerCase();
//        return helper(A, B);
//    }
//    
//    public static int helper(String A, String B) {
//        if (A.contains(B)) {
//            return B.length();
//        } else {
//            System.out.println("Searching: " + B.substring(1) + " " + B.substring(0, B.length() - 1));
//            int res1 = helper(A, B.substring(1));
//            int res2 = helper(A, B.substring(0, B.length() - 1));
//            if (res1 > res2) {
//                return res1;
//            } else {
//                return res2;
//            }
//        }
//    }

    public static void main(String[] args) {
//        System.out.println(longestCommonSubstring("ABCD", "CBCE"));
        System.out.println(longestCommonSubstring("abccccccccccde", "dbccccccabccde"));
    }

}
