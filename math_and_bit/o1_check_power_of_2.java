package math_and_bit;

public class o1_check_power_of_2 {
    
    /*
     * @param n: An integer
     * @return: True or false
     */
    public static boolean checkPowerOf2(int n) {
        // runtime: 1
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkPowerOf2(4));
    }

}
