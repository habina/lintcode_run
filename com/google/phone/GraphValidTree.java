package com.google.phone;

public class GraphValidTree {
    
    public static class UnionFind {
        
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
//            System.out.println("node: " + i + " " + j);
//            System.out.println("group: " + gi + " " + gj);
//            System.out.println("size: " + size[gi] + " " + size[gj]);
//            System.out.println();
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

    
    // union find way
    public static boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length || n == 0) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return false;
            }
        }
        
        return uf.count() == 1;
    }
    
//    DFS way
//    public static boolean validTree(int n, int[][] edges) {
//        if (n < 2) {
//            return true;
//        }
//        if (edges.length == 0) {
//            return false;
//        }
//        Set<Integer> visited = new HashSet<Integer>();
//        Map<Integer, List<Integer>> g = buildGraph(edges);
//        
//        return (dfs(visited, g, -1, 0) && visited.size() == n);
//    }
    
//    public static boolean dfs(Set<Integer> visited, Map<Integer, List<Integer>> g, int preNode, int node) {
//        if (!visited.contains(node)) {
//            visited.add(node);
//            for (Integer next : g.get(node)) {
//                if (next != preNode) {
//                    if (!dfs(visited, g, node, next)) {
//                        return false;
//                    }
//                }
//            }
//            return true;
//        }
//        return false;
//    }
//    
//    public static HashMap<Integer, List<Integer>> buildGraph(int[][] edges) {
//        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
//        
//        for (int[] edge : edges) {
//            if (!map.containsKey(edge[0])) {
//                map.put(edge[0], new ArrayList<Integer>());
//            }
//            if (!map.containsKey(edge[1])) {
//                map.put(edge[1], new ArrayList<Integer>());
//            }
//            map.get(edge[0]).add(edge[1]);
//            map.get(edge[1]).add(edge[0]);
//        }
//        
//        return map;
//    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{5,6},{6,7},{9,0},{3,7},{4,8},{1,8},{5,2},{5,3}};
        System.out.println(validTree(10, edges));
    }

}
