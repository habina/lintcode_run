package string;
import java.util.HashMap;

public class compare_strings {

    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public static boolean compareStrings(String A, String B) {
        // write your code here
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (char b : B.toCharArray()) {
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
            } else {
                map.put(b, 1);
            }
        }
        
        for (char a : A.toCharArray()) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) - 1);
                if (map.get(a) == 0) {
                    map.remove(a);
                }
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(compareStrings("ABCD", "AABC"));
    }

}
