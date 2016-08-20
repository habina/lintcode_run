package greedy;

import java.util.ArrayList;
import java.util.HashMap;

public class majority_number_iii {
    
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public static int majorityNumber(ArrayList<Integer> nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (Integer i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else if (map.size() < (k - 1)) {
                map.put(i, 1);
            } else {
                removeKey(map);
            }
        }
        
        for (Integer key : map.keySet()) {
            map.put(key, 0);
        }
        
        for (Integer i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
        }
        
        int maxKey = 0;
        int maxCount = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > maxCount) {
                maxKey = key;
                maxCount = map.get(key);
            }
        }
        
        return maxKey;
    }
    
    public static void removeKey(HashMap<Integer, Integer> map) {
        ArrayList<Integer> removeList = new ArrayList<Integer>();
        for (Integer key : map.keySet()) {
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0) {
                removeList.add(key);
            }
        }
        
        for (Integer key : removeList) {
            map.remove(key);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(1);
        System.out.println(majorityNumber(list, 3));
    }
}
