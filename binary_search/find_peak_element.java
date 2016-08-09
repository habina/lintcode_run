package binary_search;

public class find_peak_element {

    /**
     * @param A:
     *            An integers array.
     * @return: return any of peek positions.
     */
    public static int findPeak(int[] A) {
        // runtime: logN
        int begin = 0;
        int end = A.length - 1;

        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            if (A[mid] < A[mid + 1]) {
                begin = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[begin] < A[end]) {
            return end;
        } else {
            return begin;
        }
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 1, 3, 4, 5, 7, 6 };
        System.out.println(findPeak(A));
    }

}
