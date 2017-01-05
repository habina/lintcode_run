package com.google.phone;

import java.util.Arrays;

public class RangeSumQuery2DMutable {

    int[][] tree;
    int[][] matrix;

    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix.length == 0) {
            this.tree = new int[1][1];
        } else {
            this.tree = new int[matrix.length + 1][matrix[0].length + 1];
        }

        this.matrix = matrix;
        
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                add(i, j, this.matrix[i][j]);
            }
        }
    }
    
    public int lowerBit(int k) {
        return k & -k;
    }
    
    public void add(int row1, int col1, int val) {
        for (int i = row1 + 1; i < this.tree.length; i += lowerBit(i)) {
            for (int j = col1 + 1; j < this.tree[i].length; j += lowerBit(j)) {
                tree[i][j] += val;
            }
        }
    }
    
    public int sum(int row, int col){
        int sum = 0;
        for (int i = row; i > 0; i -= lowerBit(i)) {
            for (int j = col; j > 0; j -= lowerBit(j)) {
                sum += tree[i][j];
            }
        }
        
        return sum;
    }

    public void update(int row, int col, int val) {
        int diff = val - this.matrix[row][col];
        add(row, col, diff);
        this.matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
//        System.out.println(sum(row2+1, col2+1));
//        System.out.println(sum(row2 + 1, col1));
//        System.out.println(sum(row1, col2 + 1));
//        System.out.println(sum(row1, col1));
        return sum(row2 + 1, col2 + 1) - sum(row2 + 1, col1) - sum(row1, col2 + 1) + sum(row1, col1);
    }

    public static void main(String[] args) {
        test1();
//        test2();
    }
    public static void test2() {
        int[][] a = {{-4, -5}};
        RangeSumQuery2DMutable b = new RangeSumQuery2DMutable(a);
        System.out.println(b.sumRegion(0, 0, 0, 0));
        System.out.println(b.sumRegion(0, 0, 0, 1));
        System.out.println(b.sumRegion(0, 1, 0, 1));
    }
    
    public static void test1() {
        int[][] a = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };
        RangeSumQuery2DMutable b = new RangeSumQuery2DMutable(a);
        System.out.println(b.sumRegion(2, 1, 4, 3));
        b.update(3, 2, 2);
        System.out.println(b.sumRegion(2, 1, 4, 3));
    }


}
