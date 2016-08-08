package binary_search;

public class first_position_of_target {

    /**
     * @param nums:
     *            The integer array.
     * @param target:
     *            Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearch(int[] nums, int target) {
        // runtime: logn
        int begin = 0;
        int end = nums.length - 1;
        int found = -1;

        while (begin + 1 < end) {
            int mid = begin + (end - begin) / 2;

            if (nums[mid] == target) {
                end = mid;
            }
            
            if (nums[mid] < target) { 
                begin = mid;
            } else {
                end = mid;
            }
        }

        if (nums[begin] == target) {
            found = begin;
        } else if (nums[end] == target) {
            found = end;
        }
        
        return found;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 4, 5, 10 };
        int target = 3;
        System.out.println(binarySearch(nums, target));
    }

}
