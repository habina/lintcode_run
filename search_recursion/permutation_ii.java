package search_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class permutation_ii {

    /**
     * @param nums:
     *            A list of integers.
     * @return: A list of unique permutations.
     */
    public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // backtracking way
        // runtime: n * n!
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        Collections.sort(nums);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        int[] visited = new int[nums.size()];
        dfs(nums, cur, res, visited);
        return res;
    }

    public static void dfs(ArrayList<Integer> nums, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res,
        int[] visited) {
        if (cur.size() == nums.size()) {
            // System.out.println("add: " + cur);
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            // the reason for visited[i-1] == 0 is required for continuing.
            // visited[i-1] == 1, means nums[i] placed at current position is a
            // new permutation
            // visited[i-1] == 0, means nums[i] places at current position is an
            // old permutation,
            // because nums[i] used to be placed at there before.
            // visited[i-1] == 0 means, it did not visited or not selected in
            // this permutation.
            if (visited[i] == 1 || (i != 0 && visited[i - 1] == 0 && nums.get(i) == nums.get(i - 1))) {
                continue;
            }
            /*
             * 上面的判断主要是为了去除重复元素影响。 比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
             * 我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
             * 当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就 不应该让后面的2使用。
             */
            visited[i] = 1;
            cur.add(nums.get(i));
            // System.out.println();
            // System.out.println(i);
            // System.out.println("building: " + cur);
            // System.out.println("visited: " + Arrays.toString(visited));
            dfs(nums, cur, res, visited);
            visited[i] = 0;
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        System.out.println(permuteUnique(list));
    }

}
