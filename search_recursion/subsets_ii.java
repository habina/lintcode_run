package search_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class subsets_ii {

     /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> s) {
        // iterative way

        Collections.sort(s);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        
        // add empty set, because this is included for sure.
        res.add(new ArrayList<Integer>());
        
        while(i < s.size()) {
            int countDup = 1;
            while ((i + countDup) < s.size() && s.get(i) == s.get(i + countDup)) {
                countDup++;
            }

            ArrayList<ArrayList<Integer>> withCur = new ArrayList<ArrayList<Integer>>();
            int cur = s.get(i);
            
            for (ArrayList<Integer> list : res) {
                ArrayList<Integer> withoutCur = new ArrayList<Integer>(list);
                for (int j = 1; j <= countDup; j++) {
                    withoutCur.add(cur);
                    withCur.add(new ArrayList<Integer>(withoutCur));
                }
            }
            
            // add all withCur
            res.addAll(withCur);
            i += countDup;
        }
        return res;
    }

//    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> s) {
//        Collections.sort(s);
//        List<Integer> ss = s;
//        ArrayList<Integer> row = new ArrayList<Integer>();
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        subsetsWithDup(ss, 0, row, res);
//        return res;
//    }
//
//    /**
//     * @param S:
//     *            A set of numbers.
//     * @return: A list of lists. All valid subsets.
//     */
//    public static void subsetsWithDup(List<Integer> s, int start, ArrayList<Integer> row,
//        ArrayList<ArrayList<Integer>> res) {
//        // recursive backtracking way 1
//        res.add(new ArrayList<Integer>(row));
//
//        for (int i = start; i < s.size(); i++) {
//            if (i != start && s.get(i) == s.get(i - 1)) {
//                continue;
//            }
//            row.add(s.get(i));
//            subsetsWithDup(s, i + 1, row, res);
//            row.remove(row.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<Integer>();
        s.add(1);
        s.add(1);
        System.out.println(subsetsWithDup(s));
    }

}
