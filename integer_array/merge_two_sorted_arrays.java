package integer_array;

public class merge_two_sorted_arrays {
    
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {
        // runtime: m + n
        if (A.length == 0) {
            return B;
        }

        if (B.length == 0) {
            return A;
        }

        if (B.length < A.length) {
            return mergeSortedArray(B, A);
        } else {
            int i = 0;
            int j = 0;
            int count = 0;
            int[] res = new int[A.length + B.length];
            while (i < A.length && j < B.length) {
                if (A[i] < B[j]) {
                    res[count] = A[i];
                    i++;
                } else {
                    res[count] = B[j];
                    j++;
                }
                count++;
            }

            while (i < A.length) {
                res[count] = A[i];
                count++;
                i++;
            }
            
            while (j < B.length) {
                res[count] = B[j];
                count++;
                j++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {2,4,5,6};
        int[] c = mergeSortedArray(a, b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }

}
