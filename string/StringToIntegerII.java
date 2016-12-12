package string;

public class StringToIntegerII {

    /**
     * @param str:
     *            A string
     * @return An integer
     */
    public static int atoi(String str) {
        String s = str.split("\\.")[0];
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        long res = 0;
        if (s.charAt(0) == '-') {
            res = toInteger(s.substring(1));
            res *= -1;
        } else if (s.charAt(0) == '+'){
            res = toInteger(s.substring(1));
        } else {
            res = toInteger(s);
        }

        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) res;
        }
    }
    
    public static long toInteger(String str) {
        long res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 48 || str.charAt(i) > 57) {
                return res;
            }
            if (i > 10) {
                break;
            }
            res = res * 10 + ((str.charAt(i) - 48));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(atoi("10"));
        System.out.println(atoi("-1"));
        System.out.println(atoi("123123123123123"));
        System.out.println(atoi("1.0"));
        System.out.println(atoi("    -5211314"));
        System.out.println(atoi("    52lintcode  "));
    }

}
