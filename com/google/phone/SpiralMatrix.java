package com.google.phone;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return lst;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        
        while (m > 0 && n > 0) {
            
            // only one row or one column
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    lst.add(matrix[x][y]);
                    y++;
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    lst.add(matrix[x][y]);
                    x++;
                }
                break;
            }
            
            // moving right 
            for (int i = 0; i < n - 1; i++) {
                lst.add(matrix[x][y]);
                y++;
            }
            
            // moving down
            for (int i = 0; i < m - 1; i++) {
                lst.add(matrix[x][y]);
                x++;
            }
            
            // moving left
            for (int i = 0; i < n - 1; i++) {
                lst.add(matrix[x][y]);
                y--;
            }
            
            // moving up
            for (int i = 0; i < m - 1; i++) {
                lst.add(matrix[x][y]);
                x--;
            }
            
            x++;
            y++;
            m -= 2;
            n -= 2;
        }
        
        return lst;
    }

}
