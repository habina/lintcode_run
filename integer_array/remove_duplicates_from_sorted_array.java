package integer_array;

public class remove_duplicates_from_sorted_array {

    /**
     * @param A:
     *            a array of integers
     * @return : return an integer
     */
    public static int removeDuplicates(int[] nums) {
        // runtime: O(n)
        int count_unique = nums.length;
        if (count_unique == 0 || count_unique == 1){
            return nums.length;
        } else {
            int loc = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    count_unique--;
                } else {
                    nums[loc] = nums[i];
                    loc++;
                }
            }
        }
        
        return count_unique;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println(removeDuplicates(nums));
    }

}
