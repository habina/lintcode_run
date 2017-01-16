package combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            dfs(res, cur, candidates, target-candidates[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }

}
