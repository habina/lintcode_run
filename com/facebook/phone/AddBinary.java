package com.facebook.phone;

public class AddBinary {
    
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 && j >= 0) {
            int sum = carry + Integer.valueOf(a.charAt(i)) + Integer.valueOf(b.charAt(j));
            carry = sum >>> 1 & 0x1;
            sb.append(sum % 2);
            i--;
            j--;
        }
        
        while (i >= 0) {
            int sum = carry + Integer.valueOf(a.charAt(i));
            carry = sum >>> 1 & 0x1;
            sb.append(sum % 2);
            i--;
        }
        
        while (j >= 0) {
            int sum = carry + Integer.valueOf(b.charAt(j));
            carry = sum >>> 1 & 0x1;
            sb.append(sum % 2);
            j--;
        }
        
        if (carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }

}
