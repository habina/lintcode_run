package search_recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class subsets {

    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // iterative way
        
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            ArrayList<ArrayList<Integer>> withoutCur = new ArrayList<ArrayList<Integer>>();
            
            for (ArrayList<Integer> list : res) {
                withoutCur.add(new ArrayList<Integer>(list));
            }
            
            // add cur to withoutCur
            for (ArrayList<Integer> list : withoutCur) {
                list.add(cur);
            }
            
            // add cur as a list itself
            ArrayList<Integer> withCur = new ArrayList<Integer>();
            withCur.add(cur);
            res.add(withCur);
            // add all withoutCur
            res.addAll(withoutCur);
        }
        
        // add empty set
        res.add(new ArrayList<Integer>());

        return res;
    }

//    /**
//     * @param S: A set of numbers.
//     * @return: A list of lists. All valid subsets.
//     */
//    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
//        // recursive way
//        Arrays.sort(nums);
//        ArrayList<ArrayList<Integer>> res = subsets(nums, 0);
//        return res;
//    }
//
//    public static ArrayList<ArrayList<Integer>> subsets(int[] nums, int start) {
//        // recursive way
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        if (start == nums.length) {
//            res.add(new ArrayList<Integer>());
//            return res;
//        }
//        
//        int first = nums[start];
//        ArrayList<ArrayList<Integer>> withoutFirst = subsets(nums, start + 1);
//        for (ArrayList<Integer> list : withoutFirst) {
//            ArrayList<Integer> copy = new ArrayList<Integer>();
//            copy.add(first);
//            copy.addAll(list);
//            res.add(copy);
//        }
//        res.addAll(withoutFirst);
//        
//        return res;
//    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(subsets(a));
    }

}
