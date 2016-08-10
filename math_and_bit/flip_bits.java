package math_and_bit;

public class flip_bits {
    
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // runtime: 1
        if (a == 0 && b == 0) {
            return 0;
        }
        
        if (a == 0) {
            return countOne(b);
        } else if (b == 0) {
            return countOne(a);
        } else {
            int diff = (a ^ b) & 0x1;
            return diff + bitSwapRequired(a >>> 1, b >>> 1);
        }

    }
    
    public static int countOne(int a) {
        if (a == 0) {
            return 0;
        }
        int diff = a & 0x1;
        return diff + countOne(a >>> 1);
    }

    public static void main(String[] args) {
        System.out.println(bitSwapRequired(31, 14));
    }

}
