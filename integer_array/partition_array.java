package integer_array;

public class partition_array {
    
    /** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public static int partitionArray(int[] nums, int k) {
        // runtime: in-place O(n)
        int loc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                swap(nums, i, loc);
                loc++;
            }
        }
        return loc;
    }
    
    public static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] =t;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,1};
        int k = 2;
        System.out.println(partitionArray(nums, k));
    }

}
