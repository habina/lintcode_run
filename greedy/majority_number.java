package greedy;

import java.util.ArrayList;

public class majority_number {
    
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public static int majorityNumber(ArrayList<Integer> nums) {
        // Moore's voting algorithm
        // if count == 0, get the new case number,
        // if see the same case again, count++,
        // if not, count--
        // The reason behind this is because if the majority number exist,
        // the case number count won't be -- unitil 0.
        
        // runtime: n
        
        int res = -1;
        int count = 0;
        for (Integer i : nums) {
            if (count == 0) {
                count++;
                res = i;
            } else {
                if (i == res) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(2);
        System.out.println(majorityNumber(nums));
    }

}
