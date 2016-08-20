package greedy;

import java.util.ArrayList;

public class majority_number_ii {

    /**
     * @param nums:
     *            A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public static int majorityNumber(ArrayList<Integer> nums) {
        // still using Moore voting algorithm, but two candidates and two counts
        int can1 = 0;
        int can2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for (Integer i : nums) {
            if (i == can1) {
                cnt1++;
            } else if (i == can2) {
                cnt2++;
            } else if (cnt1 == 0) {
                can1 = i;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                can2 = i;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (Integer i : nums) {
            if (i == can1) {
                cnt1++;
            } else if (i == can2) {
                cnt2++;
            }
        }

        if (cnt1 > cnt2) {
            return can1;
        } else {
            return can2;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(1);
        System.out.println(majorityNumber(list));
    }

}
