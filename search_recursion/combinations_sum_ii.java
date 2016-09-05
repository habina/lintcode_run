package search_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinations_sum_ii {

    /**
     * @param num:
     *            Given the candidate numbers
     * @param target:
     *            Given the target number
     * @return: All the combinations that sum to target
     */
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        int[] visited = new int[num.length];
        List<Integer> cur = new ArrayList<Integer>();
        dfs(num, visited, target, 0, cur, res);
        return res;
    }

    public static void dfs(int[] num, int[] visited, int target, int start, List<Integer> cur, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = start; i < num.length; i++) {
            if (i != 0 && num[i - 1] == num[i] && visited[i - 1] == 0) {
                continue;
            }

            cur.add(num[i]);
            visited[i] = 1;
            dfs(num, visited, target - num[i], i + 1, cur, res);
            visited[i] = 0;
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] c = { 10, 1, 6, 7, 2, 1, 5 };
        System.out.println(combinationSum2(c, 8));
    }

}
