package combination.sum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] a = {1,2,3,4,5,6,7,8,9};
        if (n == 0) {
            return res;
        }
        
        dfs(res, k, n, a, 0, new ArrayList<Integer>());
        return res;
    }
    
    public void dfs(List<List<Integer>> res, int k, int n, int[] a, int start, ArrayList<Integer> cur) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = start; i < a.length; i++) {
            cur.add(a[i]);
            dfs(res, k - 1, n - a[i], a, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

}
