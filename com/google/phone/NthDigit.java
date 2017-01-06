package com.google.phone;

public class NthDigit {
    
    public static int findNthDigit(int n) {
        int digitLength = 1;
        int count = 9;
        long base = 1;
        
        while (n > digitLength * count * base) {
            n -= digitLength * count * base;
            base *= 10;
            digitLength++;
        }
        
        base += (n - 1) / digitLength;
        String s = String.valueOf(base);
        
        return Character.getNumericValue(s.charAt((n - 1) % digitLength));
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(2147483647));
    }

}
