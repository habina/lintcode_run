package greedy;

public class single_number {

    /**
     * @param A
     *            : an integer array return : a integer
     */
    public static int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = (res ^ A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2, 1, 3, 4, 3 };
        System.out.println(singleNumber(A));
    }

}
