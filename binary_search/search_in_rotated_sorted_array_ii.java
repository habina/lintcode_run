package binary_search;

public class search_in_rotated_sorted_array_ii {

    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public static boolean search(int[] A, int target) {
        if (A.length == 0) {
            return false;
        }
        
        int begin = 0;
        int end = A.length - 1;
        
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            
            if (A[mid] == target) {
                return true;
            }
            
            if (A[begin] < A[mid]) {
                // numbers between begin and mid are sorted.
                if (A[mid] > target && target >= A[begin]) {
                    end = mid;
                } else {
                    begin = mid;
                }
                
            } else if (A[mid] < A[end]) {
                // numbers between mid and end are sorted.
                if (A[mid] < target && target <= A[end]) {
                    begin = mid;
                } else {
                    end = mid;
                }
            } else {
                begin++;
            }
        }
        
        if (A[begin] == target || A[end] == target) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] A = { 1001, 10001, 10007, 1, 10, 101, 201 };
        int target = 10001;
        System.out.println(search(A, target));
    }

}
