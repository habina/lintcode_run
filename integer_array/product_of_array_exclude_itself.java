package integer_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class product_of_array_exclude_itself {
    
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public static ArrayList<Long> productExcludeItself(List<Integer> A) {
        // runtime: n
        ArrayList<Long> res = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return res;
        } else {
            long[] forward = new long[A.size()];
            long[] backward = new long[A.size()];
            forward[0] = 1;
            backward[A.size() - 1] = 1;
            
            for (int i = 1; i < A.size(); i++) {
                forward[i] = A.get(i - 1) * forward[i - 1];
            }
            for (int i = A.size() - 2; i >= 0; i--) {
                backward[i] = A.get(i + 1) * backward[i + 1];
            }
            
            for (int i = 0; i < A.size(); i++) {
                res.add(forward[i] * backward[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3);
        System.out.println(productExcludeItself(A));
    }

}
