package com.facebook.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        ArrayList<String> res = new ArrayList<String>();
        dfs(map, res, digits, "");
        return res;
    }
    
    public void dfs(Map<Character, char[]> map, ArrayList<String> res, String digits, String cur) {
        if (digits.length() == 0) {
            if (!cur.isEmpty()) {
                res.add(cur);
            }
            return;
        }
        
        char[] val = map.get(digits.charAt(0));
        for (char c : val) {
            dfs(map, res, digits.substring(1), cur + c);
        }
    }

}
