package binary_search;

public class search_a_2d_matrix {

    /**
     * @param matrix,
     *            a list of lists of integers
     * @param target,
     *            an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // runtime: logm + logn
        
        if (matrix.length == 0) {
            return false;
        }
        
        // search row
        int row_begin = 0;
        int row_end = matrix.length - 1;
        while (row_begin + 1 < row_end) {
            int row_mid = row_begin + (row_end - row_begin) / 2;
            if (matrix[row_mid].length != 0 && matrix[row_mid][0] == target) {
                return true;
            }
            if (matrix[row_mid].length != 0 && matrix[row_mid][0] < target) {
                row_begin = row_mid;
            } else {
                row_end = row_mid;
            }
        }

        // default search from row_begin
        int row = row_begin;
        // search from row_end
        if (matrix[row_end].length != 0 && matrix[row_end][0] <= target) {
            row = row_end;
        }

        // search by column
        int col_begin = 0;
        int col_end = matrix[row].length - 1;
        while (col_begin + 1 < col_end) {
            int col_mid = col_begin + (col_end - col_begin) / 2;
            if (matrix[row][col_mid] == target) {
                return true;
            }

            if (matrix[row][col_mid] < target) {
                col_begin = col_mid;
            } else {
                col_end = col_mid;
            }
        }
        
        return (target == matrix[row][col_begin] || target == matrix[row][col_end]);
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
