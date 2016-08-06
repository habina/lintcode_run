package integer_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class four_sum {

    /**
     * @param numbers
     *            : Give an array numbersbers of n integer
     * @param target
     *            : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *         zero.
     */
    public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        // runtime: n * nlogn
        Arrays.sort(numbers);

        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < numbers.length - 3; i++) {
            int diff = target - numbers[i];
            ArrayList<ArrayList<Integer>> sol = threeSum(numbers, i + 1, diff);
            for (ArrayList<Integer> list : sol) {
                list.add(0, numbers[i]);
                set.add(list);
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.addAll(set);
        return res;
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers, int start, int target) {
        // runtime, nlogn
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i = start; i < numbers.length - 2; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == target) {
                    ArrayList<Integer> sol = new ArrayList<Integer>();
                    sol.add(numbers[i]);
                    sol.add(numbers[left]);
                    sol.add(numbers[right]);
                    set.add(sol);
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.addAll(set);
        return res;
    }

    public static void main(String[] args) {
        // -2 -1 0 0 1 2
        int[] numbers = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        System.out.println(fourSum(numbers, target));
    }

}
