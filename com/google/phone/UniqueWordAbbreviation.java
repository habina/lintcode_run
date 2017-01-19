package com.google.phone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation {
    
    Map<String, Set<String>> map;
    
    public UniqueWordAbbreviation(String[] dictionary) {
        this.map = new HashMap<String, Set<String>>();
        for (String s : dictionary) {
            String abbr = makeAbbr(s);
            if (this.map.containsKey(abbr)) {
                this.map.get(abbr).add(s);
            } else {
                Set<String> set = new HashSet<String>();
                set.add(s);
                this.map.put(abbr, set);
            }
        }
    }
    
    private String makeAbbr(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int num = s.length() - 2;
        return "" + s.charAt(0) + num + s.charAt(s.length() - 1);
    }
    
    public boolean isUnique(String word) {
        String abbr = makeAbbr(word);
        if (map.containsKey(abbr)) {
            if (map.get(abbr).size() >= 2) {
                return false;
            } else {
                return map.get(abbr).contains(word);
            }
        }
        return true;
    }

}
