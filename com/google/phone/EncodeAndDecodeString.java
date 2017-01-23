package com.google.phone;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        
        while (s.length() != 0) {
            int index = s.indexOf("/");
            int len = Integer.valueOf(s.substring(0, index));
            res.add(s.substring(index + 1, index + 1 + len));
            s = s.substring(index + 1 + len);
        }
        
        return res;
    }

}
