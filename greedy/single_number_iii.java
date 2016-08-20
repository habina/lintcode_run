package greedy;

import java.util.ArrayList;
import java.util.List;

public class single_number_iii {

    /**
     * @param A
     *            : An integer array
     * @return : Two integers
     */
    public static List<Integer> singleNumberIII(int[] A) {
        // runtime: n
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // let x1, x2 be the two single number.
        int x1xorx2 = 0;
        for (int i : A) {
            x1xorx2 ^= i;
        }
        
        // find last bit 1 number, 1010 => 0010
        // 1010 - 1 = 1001
        // 1010 & 1001 = 1000
        // 1010 - 1000 = 0010
        int lastBit = x1xorx2 - (x1xorx2 & (x1xorx2 - 1));
        int x1 = 0;
        int x2 = 0;
        for (int i : A) {
            // since the last bit is guarantee to be diff
            // so split all i into two group, at lastBit = 0, goes to x1, otherwise x2.
            if ((lastBit & i) == 0) {
                x1 ^= i;
            } else {
                x2 ^= i;
            }
        }
        list.add(x1);
        list.add(x2);
        
        return list;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2, 3, 4, 4, 5, 3 };
        System.out.println(singleNumberIII(A));
    }

}
