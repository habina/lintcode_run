package com.leetcode.contest;

public class IslandPerimeter {
    
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += (4 - common(grid, i, j));
                }
            }
        }
        
        return perimeter;
    }
    
    public static int common(int[][] grid, int i, int j) {
        int left = i - 1;
        int right = i + 1;
        int top = j - 1;
        int bottom = j + 1;
        int res = 0;
        
        if (left >= 0) {
            res += grid[left][j];
        }
        if (right < grid.length) {
            res += grid[right][j];
        }
        
        if (top >= 0) {
            res += grid[i][top];
        }
        if (bottom < grid[i].length) {
            res += grid[i][bottom];
        }
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] a = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        System.out.println(islandPerimeter(a));
    }

}
