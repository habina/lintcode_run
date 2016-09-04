package search_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinations_sum {

    /**
     * @param candidates:
     *            A list of integers
     * @param target:An
     *            integer
     * @return: A list of lists of integers
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // backtracking
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        // start here is for searching elements only after the start postiion, inclusive.
        int start = 0;
        Arrays.sort(candidates);
        dfs(candidates, target, start, cur, res);
        return res;
    }

    public static void dfs(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i != 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] c = {2,2,3};
        System.out.println(combinationSum(c, 7));
    }

}
