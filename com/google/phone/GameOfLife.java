package com.google.phone;

public class GameOfLife {
    // 0 -> 0, 0
    // Any dead cell with exactly three live neighbors becomes a live cell, as
    // if by reproduction.
    // neighborsLives == 3, 0 -> 1, 3

    // Any live cell with two or three live neighbors lives on to the next
    // generation.
    // neighborsLives == 2 || 3, 1 -> 1, 1

    // Any live cell with fewer than two live neighbors dies, as if caused by
    // under-population.
    // neighborsLives < 2, 1 -> 0, 2
    // Any live cell with more than three live neighbors dies, as if by
    // over-population..
    // neighborsLives > 3, 1 -> 0, 2

    final static int[] dx = { 1, -1, 1, -1, 0, 0, 1, -1 };
    final static int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };

    public static void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int lives = neighborLives(board, i, j);
                if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 0) {
                    if (lives == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }

    public static int neighborLives(int[][] board, int i, int j) {
        int count = 0;

        for (int z = 0; z < dx.length; z++) {
            int x = i + dx[z];
            int y = j + dy[z];
            if (isValid(board, x, y)) {
                if (board[x][y] == 1 || board[x][y] == 2) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isValid(int[][] board, int i, int j) {
        if (i < board.length && i >= 0) {
            if (j < board[i].length && j >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = { { 0, 0, 0, 0 }, { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        gameOfLife(a);
    }

}
