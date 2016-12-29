package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class next_permutation {

    /**
     * @param nums:
     *            an array of integers
     * @return: return nothing (void), do not return anything, modify nums
     *          in-place instead
     */
    public static int[] nextPermutation(int[] nums) {
        // runtime, n
        int firstDecreaseIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                firstDecreaseIndex = i;
                break;
            }
        }
        int firstLarger = -1;
        if (firstDecreaseIndex != -1) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[firstDecreaseIndex]) {
                    firstLarger = i;
                    break;
                }
            }
            swap(nums, firstDecreaseIndex, firstLarger);
        }

        inplaceReverse(nums, firstDecreaseIndex + 1);
        return nums;
    }

    public static void inplaceReverse(int[] a, int start) {
        int end = a.length - 1;
        while (start != end && start < end) {
            swap(a, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 3 };
        int[] nums2 = { 4, 3, 2, 1 };
        int[] nums3 = { 1, 2, 3, 1, 2, 3, 1, 2, 3 };
        int[] res = nextPermutation(nums);
        int[] res1 = nextPermutation(nums2);
        int[] res2 = nextPermutation(nums3);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }

}
