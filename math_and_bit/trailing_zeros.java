package math_and_bit;

public class trailing_zeros {
    
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public static long trailingZeros(long n) {
        long count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeros(11));
    }

}
