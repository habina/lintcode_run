package search_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class n_queens {

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

        dfs(res, board, 0);
        return res;
    }

    static void dfs(ArrayList<ArrayList<String>> res, int[] board, int curLevel) {
        if (curLevel == board.length) {
            res.add(buildBoard(board));
            return;
        }

        Set<Integer> good = goodIndex(board, curLevel);
        if (good.size() == 0) {
            return;
        }
        
        for (Integer pos : good) {
            board[curLevel] = pos;
            dfs(res, board, curLevel + 1);
        }

    }

    static Set<Integer> goodIndex(int[] board, int curLevel) {
        Set<Integer> res = new HashSet<Integer>();
        for (int i = 0; i < board.length; i++) {
            res.add(i);
        }

        for (int i = 0; i < curLevel; i++) {
            int pos = board[i];
            res.remove(pos);
            int lineDiff = curLevel - i;
            res.remove(pos + lineDiff);
            res.remove(pos - lineDiff);
        }

        return res;
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
        ArrayList<ArrayList<String>> res = solveNQueens(4);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);

        for (List<String> list : res) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

}
