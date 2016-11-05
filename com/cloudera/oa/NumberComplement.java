package com.cloudera.oa;

public class NumberComplement {
    
    static int getIntegerComplement(int n) {
        int mask = 0x1 << 31;
        
        while ((mask & n) == 0) {
            mask = (mask >>> 1);
        }
        
        mask = (mask | (mask - 1));
        n = (mask & (n ^ 0xffffffff));
        
        return n;
    }

    public static void main(String[] args) {
        System.out.println(getIntegerComplement(50));
        System.out.println(getIntegerComplement(100));
    }

}
