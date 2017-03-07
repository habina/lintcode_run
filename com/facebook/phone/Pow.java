package com.facebook.phone;

public class Pow {
    
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            return myPow(1 / x, n * -1);
        } else {
            int half = n / 2;
            int remain = n - 2 * half;
            double halfRes = myPow(x, half);
            double remainRes = myPow(x, remain);
            return halfRes * halfRes * remainRes;
        }
    }

}
