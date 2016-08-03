package integer_array;

public class first_missing_positive {

    /**
     * @param A:
     *            an array of integers
     * @return: an integer
     */
    public static int firstMissingPositive(int[] A) {
        // Runtime, n
        int i = 0;

        while (i < A.length) {
            // 1. the number is miss placed. A[i] != (i + 1)
            // 2. the number is in valid index range. A[i] > 0 && A[i] <= n
            // 3. the number at index i != to the number at index A[i] - 1
            if (A[i] != (i + 1) && A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }

        for (i = 0; i < A.length; i++) {
            if (A[i] != (i + 1)) {
                return i + 1;
            }
        }

        return A.length + 1;
    }

    public static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    // /**
    // * @param A:
    // * an array of integers
    // * @return: an integer
    // */
    // public static int firstMissingPositive(int[] A) {
    // // Runtime, n ^ 2
    // int first = 1;
    //
    // int i = 0;
    // while (i < A.length) {
    // if (A[i] == first) {
    // first++;
    // i = 0;
    // } else {
    // i++;
    // }
    // }
    //
    // return first;
    // }

    public static void main(String[] args) {
        int[] A = { 1, 2, 0 };
        System.out.println(firstMissingPositive(A));
        int[] B = { 2, 1 };
        System.out.println(firstMissingPositive(B));
        int[] C = { 1, 1 };
        System.out.println(firstMissingPositive(C));
    }

}
