package integer_array;

public class merge_sorted_array {
    
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // runtime: m + n, merge reversely
        if (m == 0 || n == 0) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int loc = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[loc] = A[i];
                i--;
            } else {
                A[loc] = B[j];
                j--;
            }
            loc--;
        }
        
        while (j >= 0) {
            A[loc] = B[j];
            loc--;
            j--;
        }
         
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 0, 0};
        int[] b = {2, 4};
        
        mergeSortedArray(a, 3, b, 2);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}
