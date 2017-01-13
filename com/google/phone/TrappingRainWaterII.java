package com.google.phone;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TrappingRainWaterII {
    
    public static class Cell implements Comparable<Cell>{
        int i;
        int j;
        int height;
        public Cell(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }

        @Override
        public int compareTo(Cell o) {
            return this.height - o.height;
        }
    }

    public static int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        int res = 0;
        int curSeaLevel = Integer.MIN_VALUE;
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
        // default all false
        boolean[][] visited = new boolean[m][n];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        // push all edge cell into pq
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            curSeaLevel = Math.max(curSeaLevel, cur.height);
            
            for (int z = 0; z < dx.length; z++) {
                int x = cur.i + dx[z];
                int y = cur.j + dy[z];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                if (heightMap[x][y] < curSeaLevel) {
                    res += curSeaLevel - heightMap[x][y];
                }
                visited[x][y] = true;
                pq.offer(new Cell(x, y, heightMap[x][y]));
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
        // System.out.println(trap(a));
        System.out.println(trapRainWater(a));
    }

}
