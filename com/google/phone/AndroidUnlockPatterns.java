package com.google.phone;

import java.util.HashSet;
import java.util.Set;

public class AndroidUnlockPatterns {
    
    public int numberOfPatterns(int m, int n) {
        // build 2d array to record the jump numbers
        // 1 2 3
        // 4 5 6
        // 7 8 9
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
        return 4 * dfs(visited, 1, 1, 0, m, n, jump)
            + 4 * dfs(visited, 2, 1, 0, m, n, jump)
            + dfs(visited, 5, 1, 0, m, n, jump);
    }
    
    public int dfs(Set<Integer> visited, int cur, int curLen, int total, int m, int n, int[][] jump) {
        if (curLen >= m && curLen <= n) {
            // if curLen in the range, total number of pattern + 1
            total++;
        }
        if (curLen > n) {
            return total;
        }
        
        visited.add(cur);
        for (int i = 1; i <= 9; i++) {
            if (!visited.contains(i) && visited.contains(jump[cur][i])) {
                total = dfs(visited, i, curLen + 1, total, m, n, jump);
            }
        }
        visited.remove(cur);
        return total;
    }

}
