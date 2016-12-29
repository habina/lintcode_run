package com.google.phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<Integer>();
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }
        Map<Integer, Set<Integer>> g = new HashMap<Integer, Set<Integer>>();
        
        // build graph
        for (int[] edge : edges) {
            if (!g.containsKey(edge[0])) {
                g.put(edge[0], new HashSet<Integer>());
            }
            if (!g.containsKey(edge[1])) {
                g.put(edge[1], new HashSet<Integer>());
            }
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        
        // add leaves
        for (int i = 0; i < n; i++) {
            if (g.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int i : leaves) {
                // remove one by one
                int next = g.get(i).iterator().next();
                g.get(next).remove(i);
                if (g.get(next).size() == 1) {
                    newLeaves.add(next);
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }

}
