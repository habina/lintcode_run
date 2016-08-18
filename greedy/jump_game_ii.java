package greedy;

public class jump_game_ii {
    
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public static int jump(int[] A) {
        // greedy way, runtime n
        // not an easy way to come up during interview.

        int maxIndex = 0; // maxIndex can be reach by using step + 1
        int step = 0;
        int curIndex = 0; // current max index
        
        for (int i = 0; i < A.length; i++) {
            if (i > curIndex) {
                curIndex = maxIndex;
                step++;
            }
            
            // update maxIndex, cause using step + 1
            maxIndex = Math.max(maxIndex, A[i] + i);
        }
        
        return step;
    }
    
//    /**
//     * @param A: A list of lists of integers
//     * @return: An integer
//     */
//    public static int jump(int[] A) {
//        // dp way, runtime: n ^ 2
//        // dp[i] stands for minimum step to reach index i.
//        // dp[j] = min(dp[j], dp[i] + 1); 
//
//        // initialize dp
//        int[] dp = new int[A.length];
//        dp[0] = 0;
//        for (int i = 1; i < A.length; i++) {
//            dp[i] = Integer.MAX_VALUE;
//        }
//
//        for (int i = 0; i < A.length; i++) {
//            // take min for preventing index out of bound
//            int farest = Math.min(A[i] + i, A.length - 1);
//            for (int j = i + 1; j <= farest; j++) {
//                dp[j] = Math.min(dp[j], dp[i] + 1);
//            }
//        }
//        return dp[A.length - 1];
//    }

    public static void main(String[] args) {
        int[] A = { 3, 2, 1, 0, 4 };
        System.out.println(jump(A));
        int[] B = { 2, 3, 1, 1, 4 };
        System.out.println(jump(B));
    }

}
