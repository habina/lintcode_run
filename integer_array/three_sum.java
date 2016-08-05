package integer_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class three_sum {

    /**
     * @param numbers
     *            : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of
     *         zero.
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        // runtime: nlogn 
        HashSet<ArrayList<Integer>> unique_res = new HashSet<ArrayList<Integer>>();
        int[] sorted = mergeSort(numbers);
        
        for (int i = 0; i < sorted.length - 2; i++) {
            int left = i + 1;
            int right = sorted.length - 1;
            while (left < right) {
                int sum = sorted[i] + sorted[left] + sorted[right];
                if (sum == 0) {
                    ArrayList<Integer> sol = new ArrayList<Integer>();
                    sol.add(sorted[i]);
                    sol.add(sorted[left]);
                    sol.add(sorted[right]);
                    unique_res.add(sol);
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0){
                    right--;
                }
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.addAll(unique_res);
        return res;
    }

    public static int[] mergeSort(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return a;
        }

        int mid = a.length / 2;
        int[] left_part = mergeSort(slice(a, 0, mid));
        int[] right_part = mergeSort(slice(a, mid, a.length));

        return mergeSortedList(left_part, right_part);
    }

    public static int[] slice(int[] a, int start, int end) {
        int[] res = new int[end - start];
        for (int i = start; i < end; i++) {
            res[i - start] = a[i];
        }
        return res;
    }

    public static int[] mergeSortedList(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[count] = a[i];
                i++;
            } else {
                res[count] = b[j];
                j++;
            }
            count++;
        }

        while (i < a.length) {
            res[count] = a[i];
            i++;
            count++;
        }

        while (j < b.length) {
            res[count] = b[j];
            j++;
            count++;
        }

        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] numbers = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(numbers));
    }

}
