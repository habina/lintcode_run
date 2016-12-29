package greedy;

import java.util.ArrayList;

public class previous_permutation {
    
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public static ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        int firstIncreaseIndex = -1;
        for (int i = nums.size() - 2; i >= 0; i--) {
            if (nums.get(i + 1) < nums.get(i)) {
                firstIncreaseIndex = i;
                break;
            }
        }
        
        int firstSmaller = -1;
        if (firstIncreaseIndex != -1) {
            for (int i = nums.size() - 1; i >= 0; i--) {
                if (nums.get(i) < nums.get(firstIncreaseIndex)) {
                    firstSmaller = i;
                    break;
                }
            }
            int tmp = nums.get(firstIncreaseIndex);
            nums.set(firstIncreaseIndex, nums.get(firstSmaller));
            nums.set(firstSmaller, tmp);
        }
        
        reverse(nums, firstIncreaseIndex + 1);
        
        return nums;
    }
    
    public static void reverse(ArrayList<Integer> nums, int start) {
        int end = nums.size() - 1;
        while (start != end && start < end) {
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(3);
        System.out.println(previousPermuation(nums));
    }

}
