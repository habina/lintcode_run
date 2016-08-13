package math_and_bit;

public class fast_power {
    
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public static int fastPower(int a, int b, int n) {
        // runtime: logn
        if (n == 1) {
            return a % b;
        } else if (n == 0) {
            return 1 % b;
        }
        
        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;
        if (n % 2 == 1) {
            product = (product * a) % b;
        }
        return (int) product;
    }

    public static void main(String[] args) {
        System.out.println(fastPower(2, 3, 31));
    }

}
