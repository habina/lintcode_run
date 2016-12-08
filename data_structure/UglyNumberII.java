package data_structure;

import java.util.ArrayList;

public class UglyNumberII {
    
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public static int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(1);
        
        while (lst.size() < n) {
            int m2 = lst.get(p2) * 2;
            int m3 = lst.get(p3) * 3;
            int m5 = lst.get(p5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            lst.add(min);
            
            if (min == m2) {
                p2++;
            }
            if (min == m3) {
                p3++;
            }
            if (min == m5) {
                p5++;
            }
        }
        
        return lst.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(9));
        System.out.println(nthUglyNumber(1));
        System.out.println(nthUglyNumber(2));
    }

}
