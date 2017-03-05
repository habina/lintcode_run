package com.veritas.oa;

public class RollingString {
    
    public static String rollingString(String s, String[] operations) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (String op : operations) {
            String[] o = op.split(" ");
            
            int start = Integer.valueOf(o[0]);
            int end = Integer.valueOf(o[1]);
            int offet = 1;
            if (o[2].equals("L")) {
                offet = -1;
            }
            
            for (int i = start; i <= end; i++) {
                char c = sb.charAt(i);
                int code = c - 'a' + offet;
                if (code < 0) {
                    code += 26;
                } else {
                    code = code % 26;
                }
                code += 'a';
                sb.replace(i, i + 1, (char) code + "");
            }
        }
        
        System.out.println(-1 % 26);
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s = "abc";
        String[] oper = {"0 0 L", "2 2 L", "0 2 R", "0 2 L"};
//        String[] oper = {"0 0 L", "2 2 L", "0 2 R"};
        System.out.println(rollingString(s, oper));
    }

}
