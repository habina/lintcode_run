package dynamic_programming;

public class MaximumProductSubarray {
    
//    /**
//     * @param nums: an array of integers
//     * @return: an integer
//     */
//    public static int maxProduct(int[] nums) {
//        // max[i] stands for max product at index i, inclusive
//        // min[i] stands for min product at index i, inclusive
//        
//        if (nums.length == 0) {
//            return 0;
//        }
//        
//        //initialize
//        int[] max= new int[nums.length];
//        int[] min = new int[nums.length];
//        
//        max[0] = min[0] = nums[0];
//        int res = nums[0];
//        
//        for (int i = 1; i < nums.length; i++) {
//            max[i] = Math.max(nums[i], Math.max(nums[i] * min[i - 1], nums[i] * max[i - 1]));
//            min[i] = Math.min(nums[i], Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]));
//            res = Math.max(res, max[i]);
//        }
//        
//        return res;
//    }
    
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public static int maxProduct(int[] nums) {
        // max[i] stands for max product at index i, inclusive
        // min[i] stands for min product at index i, inclusive
        
        if (nums.length == 0) {
            return 0;
        }
        
        //initialize
        int max= nums[0];
        int min = nums[0];
        int res = nums[0];
        int prevMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            prevMax = max;
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * prevMax, nums[i] * min));
            res = Math.max(res, max);
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
        nums[3] = -2;
        System.out.println(maxProduct(nums));
    }

}
