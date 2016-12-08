package data_structure;

public class UglyNumber {

    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public static boolean isUgly(int num) {
        while (num >= 2) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
    }

}
