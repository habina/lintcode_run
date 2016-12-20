package com.google.phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }

        List<Integer> lst = new ArrayList<Integer>();
        lst.add(0, (digits[digits.length - 1] + 1) % 10);
        int carry = (digits[digits.length - 1] + 1) / 10;

        for (int i = digits.length - 2; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            lst.add(0, sum % 10);
        }
        
        if (carry != 0) {
            lst.add(0, carry);
        }
        int[] res = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            res[i] = lst.get(i);
        }
        
        return res;
    }
    
    
    public static void main(String[] args) {
        int[] a = {1, 0};
        plusOne(a);
    }

}
