package binary_search;

public class search_insert_position {
    
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public static int searchInsert(int[] A, int target) {
        // runtime: logn
        if (A.length == 0) {
            return 0;
        }
        int begin = 0;
        int end = A.length - 1;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                begin = mid;
            } else {
                end = mid;
            }
        }
        
        if (target < A[begin]) {
            return begin;
        } else if (target < A[end]) {
            return end;
        } else {
            return end + 1;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert(A, target));
    }

}
