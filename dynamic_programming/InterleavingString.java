package dynamic_programming;

public class InterleavingString {
    
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * 
     * @param s1,
     *            s2, s3: As description.
     * @return: true or false.
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // dp[i][j] = true stands for s1[0:i) and s2[0:j) match s3[0:i+j)
        // default set to false
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= s1.length(); i++) {
            if (dp[i-1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            }
        }
        
        for (int i = 1; i <= s2.length(); i++) {
            if (dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            }
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) {
                    dp[i][j] = true;
                } else if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1 + i)) {
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }


//    /**
//     * Determine whether s3 is formed by interleaving of s1 and s2.
//     * 
//     * @param s1,
//     *            s2, s3: As description.
//     * @return: true or false.
//     */
//    public static boolean isInterleave(String s1, String s2, String s3) {
//        // recursive way
//        // runtime: 2^n
//        if (s1.length() + s2.length() != s3.length()) {
//            return false;
//        }
//
//        if (s1.isEmpty()) {
//            return s2.equals(s3);
//        }
//        if (s2.isEmpty()) {
//            return s1.equals(s3);
//        }
//
//        if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
//            return (isInterleave(s1.substring(1), s2, s3.substring(1))
//                || isInterleave(s1, s2.substring(1), s3.substring(1)));
//        } else if (s1.charAt(0) == s3.charAt(0)) {
//            return isInterleave(s1.substring(1), s2, s3.substring(1));
//        } else if (s2.charAt(0) == s3.charAt(0)) {
//            return isInterleave(s1, s2.substring(1), s3.substring(1));
//        } else {
//            return false;
//        }
//    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave("abbcddef", "accbbbcd", "abbcddefaccbbbdc"));
    }

}
