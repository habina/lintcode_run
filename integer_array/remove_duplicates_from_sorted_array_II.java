package integer_array;

public class remove_duplicates_from_sorted_array_II {

    /**
     * @param A:
     *            a array of integers
     * @return : return an integer
     */
    public static int removeDuplicates(int[] nums) {
        // runtime: O(n)
        if (nums.length < 3) {
            return nums.length;
        }
        int count_unique = nums.length;
        int loc = 1;
        int occurs = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (occurs < 2) {
                    nums[loc] = nums[i];
                    loc++;
                    occurs++;
                } else {
                    count_unique--;
                }
            } else {
                nums[loc] = nums[i];
                loc++;
                occurs = 1;
            }
        }

        return count_unique;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        System.out.println(removeDuplicates(nums));
    }

}
