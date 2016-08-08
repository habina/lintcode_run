package binary_search;

public class find_minimum_in_rotated_sorted_array {

    /**
     * @param num:
     *            a rotated sorted array
     * @return: the minimum number in the array
     */
    public static int findMin(int[] num) {
        
        // runtime: log n
        int begin = 0;
        int end = num.length - 1;
        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;
            if (num[mid] < num[end]) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        
        if (num[begin] < num[end]) {
            return num[begin];
        } else {
            return num[end];
        }
    }

    public static void main(String[] args) {
        int[] num = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(num));
    }

}
