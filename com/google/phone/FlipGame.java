package com.google.phone;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String prev = s.substring(0, i);
                String after = s.substring(i+2);
                String built = prev + "--" + after;
                res.add(built);
            }
        }
        
        return res;
    }

}
