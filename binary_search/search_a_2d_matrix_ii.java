package binary_search;

public class search_a_2d_matrix_ii {

    /**
     * @param matrix,
     *            a list of lists of integers
     * @param target,
     *            an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public static int searchMatrix(int[][] m, int target) {
        // runtime: m + n
        if (m.length == 0 || m[0].length == 0) {
            return 0;
        }
        
        // start top right corner, due to these property
        // 1. increasing from left to right.
        // 2. increasing from up to bottom.
        // in the top right corner
        // if current number is larger than target, then current column does not have the target, due to 2
        // if current number is smaller than target, then current row does not have the target, due to 1
        
        int i = 0;
        int j = m[0].length - 1;
        int count = 0;
        while (i < m.length && j >= 0) {
            if (m[i][j] > target) {
                j--;
            } else if (m[i][j] < target) {
                i++;
            } else {
                count++;
                i++;
                j--;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[][] m = new int[3][];
        int[] row1 = { 1, 2, 3 };
        int[] row2 = { 4, 5, 6 };
        int[] row3 = { 7, 8, 9 };
        m[0] = row1;
        m[1] = row2;
        m[2] = row3;
        int t = 8;
        System.out.println(searchMatrix(m, t));
        System.out.println(searchMatrix(m, 50));
    }

}
