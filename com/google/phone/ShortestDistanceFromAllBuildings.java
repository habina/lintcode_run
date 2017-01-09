package com.google.phone;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ShortestDistanceFromAllBuildings {

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }

    public static int shortestDistance(int[][] grid) {
        // 0 free land
        // 1 building
        // 2 obstacle
        if (grid.length == 0) {
            return -1;
        }

        int[][] dist = new int[grid.length][grid[0].length];
        int[][] reachPoint = new int[grid.length][grid[0].length];
        int building = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, dist, reachPoint, i, j);
                    building++;
                }
            }
        }

        int min = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dist[i][j] > 0 && reachPoint[i][j] == building) {
                    if (min == -1) {
                        min = dist[i][j];
                    } else {
                        min = Math.min(min, dist[i][j]);
                    }
                }
            }
        }

        return min;
    }

    public static void bfs(int[][] grid, int[][] dist, int[][] reach, int i, int j) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        LinkedList<Pair> q = new LinkedList<Pair>();
        Set<Pair> visited = new HashSet<Pair>();
        q.offer(new Pair(i, j));
        int level = 0;

        while (!q.isEmpty()) {
            level++;
            int size = q.size();

            for (int iter = 0; iter < size; iter++) {
                Pair cur = q.poll();
                for (int z = 0; z < dx.length; z++) {
                    int nx = cur.x + dx[z];
                    int ny = cur.y + dy[z];
                    Pair next = new Pair(nx, ny);
                    if (isValidIndex(grid, nx, ny)) {
                        if (grid[nx][ny] <= 0) {
                            if (!visited.contains(next)) {
                                dist[nx][ny] += level;
                                reach[nx][ny]++;
                                q.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
        }

    }

    public static boolean isValidIndex(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length) {
            if (j >= 0 && j < grid[i].length) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
        System.out.println(shortestDistance(a));
    }

}
