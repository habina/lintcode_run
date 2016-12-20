package com.google.phone;

public class UnionFind {
    
    int[] id;
    int[] size;
    int group;

    public UnionFind(int n) {
        id = new int[n];
        size = new int[n];
        this.group = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    
    // find group id
    public int find(int i) {
        // amortized to O(1)
        while (i != id[i]) {
            // set group number of i to the grand group number of i
            // for path compression
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    // return false if i, j are in the same group, means there is a cycle
    public boolean union(int i, int j) {
        // amortized to O(1)
        int gi = find(i);
        int gj = find(j);
//        System.out.println("node: " + i + " " + j);
//        System.out.println("group: " + gi + " " + gj);
//        System.out.println("size: " + size[gi] + " " + size[gj]);
//        System.out.println();
        if (gi == gj) {
            return false;
        }
        if (size[gj] < size[gi]) {
            // make smaller size tree as a child of bigger size tree
            id[gi] = gj;
            size[gj] += size[gi];
        } else {
            id[gj] = gi;
            size[gi] += size[gj];
        }
        this.group--;
        return true;
    }
    
    public boolean areConnected(int i, int j) {
        return find(i) == find(j);
    }
    
    public int count() {
        return this.group;
    }

}