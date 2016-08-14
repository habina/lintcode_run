package math_and_bit;

public class update_bits {
    
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public static int updateBits(int n, int m, int i, int j) {
        int leftOnes = ((0xffffffff) << (j + 1));
        int rightOnes = ((1 << i) - 1);
        
        int mask = (leftOnes | rightOnes);
        
        // left side has no ones.
        if (j >= 31) {
            mask = rightOnes;
        }
        
        n = n & mask;
        m = (m << i);
        n = n | m;
        return n;
    }
    
    public static void main(String[] args) {
        int n = -521;
        int m = 0;
        int i = 31;
        int j = 31;
        System.out.println(updateBits(n, m, i, j));
    }

}
