package binary_search;

public class search_in_rotated_sorted_array {

    /**
     * @param A
     *            : an integer rotated sorted array
     * @param target
     *            : an integer to be searched return : an integer
     */
    public static int search(int[] A, int target) {
        // runtime: logN
        if (A.length == 0) {
            return -1;
        }

        int begin = 0;
        int end = A.length - 1;

        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] < A[end]) {
                // number between mid and end are sorted
                if (target > A[mid] && target <= A[end]) {
                    begin = mid;
                } else {
                    end = mid;
                }
            } else {
                // number between start and mid are sorted
                if (target < A[mid] && target >= A[begin]) {
                    end = mid;
                } else {
                    begin = mid;
                }
            }
            
        }

        if (A[begin] == target) {
            return begin;
        } else if (A[end] == target) {
            return end;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] A = { 1001, 10001, 10007, 1, 10, 101, 201 };
        int target = 10001;
        System.out.println(search(A, target));
    }

}
