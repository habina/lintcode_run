package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubarrayII {

    /**
     * @param nums:
     *            A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public static int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums.isEmpty()) {
            return 0;
        }

        int res = Integer.MIN_VALUE;
        int[] leftMax = new int[nums.size()];
        int[] rightMax = new int[nums.size()];
        int sumCur = nums.get(0);
        leftMax[0] = nums.get(0);
        rightMax[nums.size() - 1] = nums.get(nums.size() - 1);

        for (int i = 1; i < nums.size(); i++) {
            sumCur = Math.max(nums.get(i), sumCur + nums.get(i));
            leftMax[i] = Math.max(sumCur, leftMax[i - 1]);
        }

        sumCur = nums.get(nums.size() - 1);
        for (int i = nums.size() - 2; i >= 0; i--) {
            sumCur = Math.max(nums.get(i), sumCur + nums.get(i));
            rightMax[i] = Math.max(sumCur, rightMax[i + 1]);
        }

//         System.out.println(Arrays.toString(leftMax));
//         System.out.println(Arrays.toString(rightMax));

        for (int i = 0; i < nums.size() - 1; i++) {
            res = Math.max(res, leftMax[i] + rightMax[i + 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = { -1, 4, -2, 3, -2, 3 };
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i : a) {
            nums.add(i);
        }
        System.out.println(maxTwoSubArrays(nums));
    }

}
