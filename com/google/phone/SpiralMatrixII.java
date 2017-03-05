package com.google.phone;

public class SpiralMatrixII {
    
    public static int[][] generateMatrix(int n) {
        int count = 1;
        int num = n;
        int x = 0;
        int y = 0;
        int[][] res = new int[n][n];

        while (count < num * num) {
            // moving right
            for (int i = 0; i < n - 1; i++) {
                res[x][y] = count;
                count++;
                y++;
            }
            
            // moving down
            for (int i = 0; i < n - 1; i++) {
                res[x][y] = count;
                count++;
                x++;
            }
            
            // moving left
            for (int i = 0; i < n - 1; i++) {
                res[x][y] = count;
                count++;
                y--;
            }
            
            // moving up
            for (int i = 0; i < n - 1; i++) {
                res[x][y] = count;
                count++;
                x--;
            }
            
            x++;
            y++;
            n -= 2;
        }
        
        if (num % 2 == 1) {
            res[num / 2][num / 2] = count;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        generateMatrix(3);
    }

}
