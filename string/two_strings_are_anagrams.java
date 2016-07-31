package string;
import java.util.HashMap;

public class two_strings_are_anagrams {

    public static boolean anagram(String s, String t) {
        // write your code here
        // 1. Sorting way.
        // 2. Couting way.
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        for (Character c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }
        
        if (map.size() == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(anagram("happy new year", "n ahwryeypp ea"));
    }

}
