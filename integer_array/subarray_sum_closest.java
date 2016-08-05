package integer_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class subarray_sum_closest {
    
    public static class Pair {
        int sum;
        int index;
        public Pair(int index, int sum) {
            this.sum = sum;
            this.index = index;
        }
    }
    
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public static int[] subarraySumClosest(int[] nums) {
        // runtime: nlogn
        int[] res = new int[2];
        ArrayList<Pair> list = new ArrayList<Pair>();
        list.add(new Pair(0, nums[0]));
        for (int i = 1; i < nums.length; i++) {
            list.add(new Pair(i, nums[i] + list.get(i - 1).sum));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                // TODO Auto-generated method stub
                return o1.sum - o2.sum;
            }
        });
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 1; i < list.size(); i++) {
            int diff = Math.abs(list.get(i).sum - list.get(i - 1).sum);
            if (diff < minDiff) {
                minDiff = diff;
                res[0] = Math.min(list.get(i).index, list.get(i - 1).index) + 1;
                res[1] = Math.max(list.get(i).index, list.get(i - 1).index);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-3, 1, 1, -3, 5};
        int[] res = subarraySumClosest(a);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
