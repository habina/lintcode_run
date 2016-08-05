package integer_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class two_sum {

    /*
     * @param numbers : An array of Integer
     * 
     * @param target : target = numbers[index1] + numbers[index2]
     * 
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        // Runtime: n, space: n
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            if (map.containsKey(key)) {

                res[0] = i + 1;
                res[1] = map.get(key) + 1;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] n = { 0, 1, 4, 0 };
        int[] res = twoSum(n, 0);

        System.out.println(res[0]);
        System.out.println(res[1]);
    }

}
