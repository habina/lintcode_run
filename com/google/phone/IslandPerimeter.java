package com.google.phone;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += (4 - countLandNeighbor(grid, i, j));
                }
            }
        }
        
        return perimeter;
    }

    public int countLandNeighbor(int[][] grid, int i, int j) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        int count = 0;
        
        for (int z = 0; z < dx.length; z++) {
            int x = dx[z] + i;
            int y = dy[z] + j;
            
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[i].length) {
                continue;
            } else {
                if (grid[x][y] == 1) {
                    count++;
                }
            }
        }
        
        return count;
    }

}
