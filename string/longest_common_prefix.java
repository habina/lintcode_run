package string;

public class longest_common_prefix {

    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            String a = strs[0];
            String b = strs[1];
            String res = prefix(a, b);
            for (int i = 2; i < strs.length; i++) {
                res = prefix(res, strs[i]);
            }
            return res;
        }
    }
    
    public static String prefix(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return "";
        }
        if (A.charAt(0) == B.charAt(0)) {
            return A.charAt(0) + prefix(A.substring(1), B.substring(1));
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] strs = {"ABCD","ABEF","ACEF"};
        System.out.println(longestCommonPrefix(strs));
    }

}
