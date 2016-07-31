package string;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class anagrams {

    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public static List<String> anagrams(String[] strs) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        HashSet<Integer> indexSet = new HashSet<Integer>();

        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (helper(strs[i], strs[j])) {
                    if (!indexSet.contains(i)) {
                        result.add(strs[i]);
                        indexSet.add(i);
                    }
                    if (!indexSet.contains(j)) {
                        result.add(strs[j]);
                        indexSet.add(j);
                    }
                }
            }
        }
        
        return result;
    }
    
    public static boolean helper(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (char a : A.toCharArray()) {
            if (map.containsKey(a)) {
                map.put(a, 1 + map.get(a));
            } else {
                map.put(a, 1);
            }
        }
        
        for (char b : B.toCharArray()) {
            if (map.containsKey(b)) {
                map.put(b, map.get(b) - 1);
                if (map.get(b) == 0) {
                    map.remove(b);
                }
            }
        }
        
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String[] strs = {"lint", "intl", "inlt", "code"};
        System.out.println(anagrams(strs));
    }

}
