package search_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutation {
    
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static ArrayList<ArrayList<Integer>> permute(List<Integer> nums) {
        // recursive backtracking way
        // runtime: n*n!
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (nums == null || nums.size() == 0) {
            return res;
        }
        
        ArrayList<Integer> cur = new ArrayList<Integer>();
        dfs(nums, cur, res);
        return res;
    }
    
    public static void dfs(List<Integer> nums, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res) {
        if (cur.size() == nums.size()) {
            res.add(new ArrayList<Integer>(cur));
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (cur.contains(nums.get(i))) {
                continue;
            }
            cur.add(nums.get(i));
            dfs(nums, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    
//    /**
//     * @param nums: A list of integers.
//     * @return: A list of permutations.
//     */
//    public static ArrayList<ArrayList<Integer>> permute(List<Integer> list) {
//        // iterative way
//        // runtime: n*n!
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        
//        if (list == null || list.size() == 0) {
//            return res;
//        }
//        
//        res.add(new ArrayList<Integer>());
//        
//        for (int i = 0; i < list.size(); i++) {
//            ArrayList<ArrayList<Integer>> nextRes = new ArrayList<ArrayList<Integer>>();
//
//            for (ArrayList<Integer> item : res) {
//                for (int j = 0; j <= item.size(); j++) {
//                    ArrayList<Integer> copy = new ArrayList<Integer>(item);
//                    copy.add(j, list.get(i));
//                    nextRes.add(copy);
//                }
//            }
//            
//            res = nextRes;
//        }
//        
//        return res;
//    }

//    /**
//     * @param nums: A list of integers.
//     * @return: A list of permutations.
//     */
//    public static ArrayList<ArrayList<Integer>> permute(List<Integer> list) {
//        // recursive way
//        // runtime: n*n!
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        
//        if (list == null) {
//            return res;
//        }
//        
//        if (list.size() == 1) {
//            res.add(new ArrayList<Integer>(list));
//            return res;
//        }
//        
//        int first = list.get(0);
//        ArrayList<ArrayList<Integer>> withoutFirst = permute(list.subList(1, list.size()));
//        for (ArrayList<Integer> item : withoutFirst) {
//            for (int i = 0; i <= item.size(); i++) {
//                ArrayList<Integer> copy = new ArrayList<Integer>(item);
//                copy.add(i, first);
//                res.add(copy);
//            }
//        }
//        
//        return res;
//    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(permute(list));
    }

}
