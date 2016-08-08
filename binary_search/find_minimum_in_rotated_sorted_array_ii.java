package binary_search;

public class find_minimum_in_rotated_sorted_array_ii {

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

            while (num[mid] == num[end]) {
                end--;
            }

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
        int[] num = { 999, 999, 1000, 1000, 10000, 0, 999, 999, 999 };
        System.out.println(findMin(num));
        int[] b = { 1, 1, -1, 1 };
        System.out.println(findMin(b));
    }

}
