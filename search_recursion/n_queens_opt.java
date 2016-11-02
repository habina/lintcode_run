package search_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class n_queens_opt {
    
    public static boolean[] down, leftDiagonal, rightDiagonal;

    /**
     * Get all distinct N-Queen solutions
     * 
     * @param n:
     *            The number of queens
     * @return: All distinct solutions For example, A string '...Q' shows a
     *          queen on forth position
     */
    static ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        int[] board = new int[n];
        down = new boolean[n];
        leftDiagonal = new boolean[2 * n - 1];
        rightDiagonal = new boolean[2 * n - 1];

        dfs(res, board, 0);
        return res;
    }

    static void dfs(ArrayList<ArrayList<String>> res, int[] board, int curLevel) {
        if (curLevel == board.length) {
            res.add(buildBoard(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            int ld = curLevel + i;
            int rd = board.length - 1 - curLevel + i;
            if (down[i] || leftDiagonal[ld] || rightDiagonal[rd]) {
                continue;
            }
            board[curLevel] = i;
            down[i] = leftDiagonal[ld] = rightDiagonal[rd] = true;
            dfs(res, board, curLevel + 1);
            down[i] = leftDiagonal[ld] = rightDiagonal[rd] = false;
        }

    }

    static ArrayList<String> buildBoard(int[] board) {
        ArrayList<String> res = new ArrayList<String>();

        char[] s = getRow(board.length);

        for (int i = 0; i < board.length; i++) {
            int pos = board[i];
            s[pos] = 'Q';
            res.add(new String(s));
            s[pos] = '.';
        }

        return res;
    }

    static char[] getRow(int n) {
        char[] row = new char[n];
        for (int i = 0; i < row.length; i++) {
            row[i] = '.';
        }
        return row;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ArrayList<ArrayList<String>> res = solveNQueens(13);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);

//        for (List<String> list : res) {
//            for (String s : list) {
//                System.out.println(s);
//            }
//            System.out.println();
//        }
    }

}
