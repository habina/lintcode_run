package search_recursion;

import java.util.ArrayList;
import java.util.List;

public class combinations {

    /**
     * @param n:
     *            Given the range of numbers
     * @param k:
     *            Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public static List<List<Integer>> combine(int n, int k) {
        // backtracking
        // runtime: n choose k
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        int[] visited = new int[n];
        subsetWithK(visited, nums, res, cur, k, 0);
        return res;
    }

    public static void subsetWithK(int[] visited, ArrayList<Integer> nums, List<List<Integer>> res,
        ArrayList<Integer> cur, int k, int start) {
        if (cur.size() == k) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            if (visited[i] == 1) {
                continue;
            }

            cur.add(nums.get(i));
            visited[i] = 1;
            subsetWithK(visited, nums, res, cur, k, i + 1);
            visited[i] = 0;
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

}
