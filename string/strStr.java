package string;
import java.util.HashMap;

public class strStr {

    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) {
            return -1;
        }
        int res = helper(source, target);
        if (res == -1) {
            return -1;
        } else {
            return res - target.length();
        }
    }
    
    public static int helper(String source, String target) {
        if (target.length() > source.length()) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }

        int res;
        if (target.charAt(0) == source.charAt(0)) {
            res = helper(source.substring(1), target.substring(1));
        } else {
            res = helper(source.substring(1), target);
        }

        if (res == -1) {
            return res;
        } else {
            return 1 + res;
        }
    }

    public static void main(String[] args) {
        System.out.println(strStr("abcdabcdefg", "bcd"));
    }

}
