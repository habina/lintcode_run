package com.amazon.phone;

import java.util.ArrayList;
import java.util.List;

public class FindWords2 {
    
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void findWords(char[][] m, String target) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.println("on " + m[i][j]);
                dfs(m, new Point(i, j), target); 
            }
        }
    }
    
    public static void dfs(char[][] m, Point p, String cur) {
        if (cur.length() == 0) {
            System.out.println("found");
            return;
        }

        List<Point> neighbors = findValidNeighbor(m, p);
        if (neighbors.isEmpty()) {
            return;
        }

        // take cur char
        if (cur.charAt(0) == m[p.x][p.y]) {
            for (Point neighbor : neighbors) {
                dfs(m, neighbor, cur.substring(1));
            }
        }

    }
    
    public static List<Point> findValidNeighbor(char[][] m, Point p) {
        List<Point> lst = new ArrayList<Point>();
        
        // left
        if (isValidIndex(m, p.x, p.y - 1)) {
            lst.add(new Point(p.x, p.y - 1));
        }
        
        // right
        if (isValidIndex(m, p.x, p.y + 1)) {
            lst.add(new Point(p.x, p.y + 1));
        }
        
        // top
        if (isValidIndex(m, p.x - 1, p.y)) {
            lst.add(new Point(p.x - 1, p.y));
        }
        
        // bottom 
        if (isValidIndex(m, p.x + 1, p.y)) {
            lst.add(new Point(p.x + 1, p.y));
        }
        
        // upper left
        if (isValidIndex(m, p.x - 1, p.y - 1)) {
            lst.add(new Point(p.x - 1, p.y - 1));
        }
        
        // upper right
        if (isValidIndex(m, p.x - 1, p.y + 1)) {
            lst.add(new Point(p.x - 1, p.y + 1));
        }
        
        // lower left
        if (isValidIndex(m, p.x + 1, p.y - 1)) {
            lst.add(new Point(p.x + 1, p.y - 1));
        }
        
        // lower right
        if (isValidIndex(m, p.x + 1, p.y + 1)) {
            lst.add(new Point(p.x + 1, p.y + 1));
        }
        
        return lst;
    }
    
    public static boolean isValidIndex(char[][] m, int i, int j) {
        if (i >= m.length || i < 0) {
            return false;
        }
        
        if (j >= m[i].length || j < 0) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        char[][] m = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        
        findWords(m, "ehi");
    }

}
