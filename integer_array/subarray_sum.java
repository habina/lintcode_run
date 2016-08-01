package integer_array;

import java.util.ArrayList;

public class subarray_sum {

    /**
     * @param nums:
     *            A list of integers
     * @return: A list of integers includes the index of the first number and
     *          the index of the last number
     */
    public static ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }
        return res;
    }

    // MLE, dp version, runtime: n ^ 2, space: n ^ 2
    // /**
    // * @param nums: A list of integers
    // * @return: A list of integers includes the index of the first number
    // * and the index of the last number
    // */
    // public static ArrayList<Integer> subarraySum(int[] nums) {
    // ArrayList<Integer> res = new ArrayList<Integer>();
    // if (nums.length == 0) {
    // return res;
    // }
    //
    // // initialize
    // int[][] dp = new int[nums.length][];
    // for(int i = 0; i < nums.length; i++) {
    // dp[i] = new int[nums.length];
    // }
    //
    // boolean flag = false;
    //
    // // dp[i][j] = dp[i][j - 1] + nums[j]
    // for (int i = 0; i < nums.length; i++) {
    // if (flag) {
    // break;
    // }
    // for (int j = i; j < nums.length; j++) {
    // if (j == i) {
    // dp[i][j] = nums[j];
    // } else {
    // dp[i][j] = dp[i][j - 1] + nums[j];
    // }
    // if (dp[i][j] == 0) {
    // res.add(i);
    // res.add(j);
    // flag = true;
    // break;
    // }
    // }
    // }
    //
    // return res;
    // }

    // TLE version, runtime: 2^n
    // /**
    // * @param nums: A list of integers
    // * @return: A list of integers includes the index of the first number
    // * and the index of the last number
    // */
    // public static ArrayList<Integer> subarraySum(int[] nums) {
    // if (nums.length == 0) {
    // return new ArrayList<Integer>();
    // }
    // return helper(nums, 0, nums.length - 1);
    // }
    //
    // public static ArrayList<Integer> helper(int[] nums, int i, int j) {
    // if (i > j) {
    // return new ArrayList<Integer>();
    // }
    // int sum = sum(nums, i, j);
    // if (sum == 0) {
    // ArrayList<Integer> res = new ArrayList<Integer>();
    // res.add(i);
    // res.add(j);
    // return res;
    // } else {
    // ArrayList<Integer> res1 = helper(nums, i + 1, j);
    // if (res1.isEmpty()) {
    // return helper(nums, i, j - 1);
    // } else {
    // return res1;
    // }
    // }
    // }
    //
    // public static int sum(int[] nums, int i, int j) {
    // int res = 0;
    // for (int a = i; a <= j; a++) {
    // res += nums[a];
    // }
    // return res;
    // }

    public static void main(String[] args) {
        int[] nums = { -3, 1, 2, -3, 4 };
        System.out.println(subarraySum(nums));
    }

}
