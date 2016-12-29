package com.google.phone;

import java.util.HashSet;
import java.util.Set;

public class AndroidUnlockPattern {

    public static int numberOfPatterns(int m, int n) {
        // build 2d array to record the jump numbers
        int[][] jump = new int[10][10];
        jump[1][3] = 2;
        jump[3][1] = 2;
        jump[1][7] = 4;
        jump[7][1] = 4;
        jump[3][9] = 6;
        jump[9][3] = 6;
        jump[7][9] = 8;
        jump[9][7] = 8;
        jump[2][8] = 5;
        jump[8][2] = 5;
        jump[4][6] = 5;
        jump[6][4] = 5;
        jump[1][9] = 5;
        jump[9][1] = 5;
        jump[3][7] = 5;
        jump[7][3] = 5;
        
        Set<Integer> visited = new HashSet<Integer>();
        // 0 is default visited
        visited.add(0);
        return 4 * dfs(m, n, 1, 0, 1, jump, visited) + 4 * dfs(m, n, 1, 0, 2, jump, visited)
            + dfs(m, n, 1, 0, 5, jump, visited);
    }

    public static int dfs(int m, int n, int len, int res, int cur, int[][] jump, Set<Integer> visited) {
        if (len >= m && len <= n) {
            res++;
        } else if (len > n) {
            return res;
        }
        visited.add(cur);
        for (int i = 1; i <= 9; i++) {
            if (!visited.contains(i) && visited.contains(jump[cur][i])) {
                res = dfs(m, n, len + 1, res, i, jump, visited);
            }
        }
        visited.remove(cur);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPatterns(1, 1));
        System.out.println(numberOfPatterns(1, 2));
        System.out.println(numberOfPatterns(2, 4));
    }

}
