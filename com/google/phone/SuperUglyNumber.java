package com.google.phone;

import java.util.ArrayList;
import java.util.List;

public class SuperUglyNumber {

    /**
     * @param n
     *            a positive integer
     * @param primes
     *            the given prime list
     * @return the nth super ugly number
     */
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        List<Integer> lst = new ArrayList<Integer>();
        lst.add(1);

        while (lst.size() < n) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < index.length; i++) {
                int tmp = lst.get(index[i]) * primes[i];
                if (tmp < min) {
                    min = tmp;
                    minIndex = i;
                }
            }
            index[minIndex]++;
            if (min != lst.get(lst.size() - 1)) {
                lst.add(min);
            }
        }
        
        return lst.get(n - 1);
    }

    public static void main(String[] args) {
        int n = 11;
        int[] primes = { 2, 3, 5};
        System.out.println(nthSuperUglyNumber(n, primes));
    }

}
