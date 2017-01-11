package com.google.phone;

public class NumberOfIslands {
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length) {
            if (j >= 0 && j < grid[i].length) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 0;
                    dfs(grid, i, j + 1);
                    dfs(grid, i, j - 1);
                    dfs(grid, i + 1, j);
                    dfs(grid, i - 1, j);
                }
            }
        }
    }

}
