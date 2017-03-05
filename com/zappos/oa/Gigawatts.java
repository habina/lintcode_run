package com.zappos.oa;

import java.util.HashSet;
import java.util.Set;

public class Gigawatts {

    static String improbabilityCalculator(String coordinates, int remove) {
        StringBuffer sb = new StringBuffer(coordinates);
        int i, j;
        if (remove > coordinates.length()) {
            return coordinates;
        }
        
        for (i = 0; i < remove; i++) {
            for (j = 0; j < sb.length() - 1
                 && sb.charAt(j) <= sb.charAt(j + 1); j++) {
            }
            sb.delete(j, j + 1);
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        String c = "746209249";
        int remove = 5;
        System.out.println(improbabilityCalculator(c, remove));
    }
}
