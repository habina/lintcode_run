package com.google.phone;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WallsAndGates {

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

    public static void wallsAndGates(int[][] rooms) {
        // -1 is wall
        // 0 is gate
        // inf is room
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }

    }

    public static void bfs(int[][] rooms, int i, int j) {
        int[] dx = { 0, 1, -1, 0 };
        int[] dy = { 1, 0, 0, -1 };
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
                    int nx = dx[z] + cur.x;
                    int ny = dy[z] + cur.y;
                    Pair next = new Pair(nx, ny);
                    if (isValidIndex(rooms, nx, ny)) {
                        if (rooms[nx][ny] != -1 && rooms[nx][ny] != 0) {
                            if (level < rooms[nx][ny]) {
                                if (!visited.contains(next)) {
                                    rooms[nx][ny] = level;
                                    q.offer(next);
                                    visited.add(next);
                                }
                            }
                        }
                    }
                }
            }

        }

    }

    public static boolean isValidIndex(int[][] rooms, int x, int y) {
        if (x >= 0 && x < rooms.length) {
            if (y >= 0 && y < rooms[x].length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int room = Integer.MAX_VALUE;
        int[][] rooms = { { room, -1, 0, room }, { room, room, room, -1 }, { room, -1, room, -1 },
            { 0, -1, room, room } };
        wallsAndGates(rooms);
        for (int[] row : rooms) {
            System.out.println(Arrays.toString(row));
        }
    }

}
