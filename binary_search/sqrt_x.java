package binary_search;

public class sqrt_x {

    /**
     * @param x:
     *            An integer
     * @return: The sqrt of x
     */
    public static int sqrt(int x) {
        // runtime: logn
        if (x == 0) {
            return 0;
        }

        int begin = 1;
        int end = x - 1;
        while (begin + 1 < end) {
            long mid = begin + (end - begin) / 2;
            long val = mid * mid;
            if (val == x) {
                return (int) mid;
            }
            if (val < x) {
                begin = (int) mid;
            } else {
                end = (int) mid;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(5));
    }

}
