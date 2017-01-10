package com.google.phone;

import java.util.Stack;

public class DecodeString {
    
    public static String decodeString(String s) {
        Stack<Integer> sNum = new Stack<Integer>();
        Stack<String> sString = new Stack<String>();
        String num = "";
        String res = "";
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num += s.charAt(i);
            } else if (s.charAt(i) == '[') {
                sNum.push(Integer.valueOf(num));
                sString.push(res);
                num = "";
                res = "";
            } else if (s.charAt(i) == ']') {
                String repeat = ""; 
                int k = sNum.pop();
                for (int j = 0; j < k; j++) {
                    repeat += res;
                }
                res = sString.pop() + repeat;
                num = "";
            } else {
                res += s.charAt(i);
            }
        }
        
        return res;
    }

//    public static String decodeString(String s) {
//        if (s.length() == 0) {
//            return s;
//        }
//        String res = "";
//        String num = "";
//        int index = 0;
//        while (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
//            num += s.charAt(index);
//            index++;
//        }
//        if (s.charAt(index) == '[') {
//            Stack<Character> stack = new Stack<Character>();
//            stack.push(s.charAt(index));
//            index++;
//            String sub = "";
//            while (index < s.length()) {
//                if (s.charAt(index) == ']') {
//                    stack.pop();
//                    if (stack.isEmpty()) {
//                        break;
//                    }
//                } else if (s.charAt(index) == '[') {
//                    stack.push('[');
//                }
//                sub += s.charAt(index);
//                index++;
//            }
//            
//            String decode = decodeString(sub);
//            for (int i = 0; i < Integer.valueOf(num); i++) {
//                res += decode;
//            }
//            s = s.substring(index + 1);
//            return res + decodeString(s);
//        } else {
//            while (index < s.length() && (s.charAt(index) < '0' || s.charAt(index) > '9')) {
//                res += s.charAt(index);
//                index++;
//            }
//            return res + decodeString(s.substring(index));
//        }
//        
//    }

    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("sd2[f2[e]g]i"));
    }

}
