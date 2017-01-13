package com.google.phone;

public class UTF8Validation {

    public static boolean validUtf8(int[] data) {
        int mask = 0xff;
        int maskMost2 = 0xc0;
        int maskMost1 = 0x80;
        int count = 0;
        
        for (int i = 0; i < data.length; i++) {
            int d = data[i] & mask;
            if (count != 0) {
                int most2 = d & maskMost2;
                if (most2 != 0x80) {
                    return false;
                }
                count--;
            } else {
                int most1 = d & maskMost1;
                if (most1 != 0) {
                    int bit = 7;
                    int m = 1 << bit;
                    // count left 1 bits
                    while ((m & d) != 0) {
                        bit--;
                        m = 1 << bit;
                        count++;
                    }
                    count--;
                    if (count == 0) {
                        // 10xxxxxx is invalid
                        return false;
                    }
                }
            }
        }
        
        return count == 0;
    }
    
    public static void main(String[] args) {
        int[] a = {235,140,4};
        System.out.println(validUtf8(a));
    }

}
