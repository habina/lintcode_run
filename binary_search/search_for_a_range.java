package binary_search;

public class search_for_a_range {

    /**
     * @param A
     *            : an integer sorted array
     * @param target
     *            : an integer to be inserted return : a list of length 2,
     *            [index1, index2]
     */
    public static int[] searchRange(int[] A, int target) {
        // search left bound

        int[] res = new int[2];
        if (A.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int begin = 0;
        int end = A.length - 1;

        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                begin = mid;
            } else if (A[mid] > target) {
                end = mid;
            }
        }

        if (A[begin] == target) {
            res[0] = begin;
        } else if (A[end] == target) {
            res[0] = end;
        } else {
            res[0] = -1;
        }

        begin = 0;
        end = A.length - 1;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (A[mid] == target) {
                begin = mid;
            } else if (A[mid] < target) {
                begin = mid;
            } else if (A[mid] > target) {
                end = mid;
            }
        }

        if (A[end] == target) {
            res[1] = end;
        } else if (A[begin] == target) {
            res[1] = begin;
        } else {
            res[1] = -1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] res = searchRange(A, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
