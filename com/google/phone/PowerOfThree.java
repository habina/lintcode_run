package com.google.phone;

public class PowerOfThree {
    
//    public static boolean isPowerOfThree(int n) {
//        if (n == 0) {
//            return false;
//        }
//        if (n == 1) {
//            return true;
//        }
//        if (n % 3 == 0) {
//            return isPowerOfThree(n / 3);
//        } else {
//            return false;
//        }
//    }

    public static boolean isPowerOfThree(int n) {
        return (n > 0 && Math.log10(n) / Math.log10(3) % 1 == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(28));
        System.out.println(isPowerOfThree(48));
    }

}
