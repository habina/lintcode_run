package greedy;

public class jump_game {

    /**
     * @param A:
     *            A list of integers
     * @return: The boolean answer
     */
    public static boolean canJump(int[] A) {
        // greedy, runtime: n
        int maxCover = 0;
        for (int i = 0; i < A.length; i++) {
            // A[i] + i = max index can be reached at the cur index i
            maxCover = Math.max(maxCover, A[i] + i);
            if (maxCover >= A.length - 1) {
                return true;
            }
            // stuck in position i
            if (maxCover == i) {
                return false;
            }
        }
        return false;
    }

//    /**
//     * @param A:
//     *            A list of integers
//     * @return: The boolean answer
//     */
//    public static boolean canJump(int[] A) {
//        // dp, runtime: n ^ 2
//        if (A.length == 0) {
//            return true;
//        }
//
//        // initialize res
//        boolean[] res = new boolean[A.length];
//        res[0] = true;
//        for (int i = 1; i < res.length; i++) {
//            res[i] = false;
//        }
//
//        for (int i = 0; i < A.length; i++) {
//            int step = A[i];
//            if (res[i]) {
//                for (int j = 1; j <= step && i + j < A.length; j++) {
//                    res[i + j] = true;
//                }
//                // faster return.
//                if (res[res.length - 1]) {
//                    return true;
//                }
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        int[] A = { 3, 2, 1, 0, 4 };
        System.out.println(canJump(A));
        int[] B = { 2, 3, 1, 1, 4 };
        System.out.println(canJump(B));
    }

}
