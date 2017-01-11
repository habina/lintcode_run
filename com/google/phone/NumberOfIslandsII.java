package com.google.phone;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        int[] roots = new int[m * n];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = -1;
        }

        int count = 0;
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int[] pos : positions) {
            int id = pos[0] * n + pos[1];
            roots[id] = id;
            count++;

            for (int z = 0; z < dx.length; z++) {
                int i = pos[0] + dx[z];
                int j = pos[1] + dy[z];
                int curId = i * n + j;
                // continue if out of bound
                if (i < 0 || i >= m || j < 0 || j >= n) {
                    continue;
                }
                // continue if the spot is water
                if (roots[curId] == -1) {
                    continue;
                }
                int rootId = find(roots, curId);
                // not equal means, id is a connection point
                // which connects two island, thus count--
                if (id != rootId) {
                    // change island id to newId
                    // this is union step
                    roots[id] = rootId;
                    id = rootId;
                    count--;
                }
            }

            res.add(count);
        }

        return res;
    }

    public int find(int[] roots, int id) {
        while (id != roots[id]) {
            // path compression
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }

}
