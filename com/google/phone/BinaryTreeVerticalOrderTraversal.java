package com.google.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryTreeVerticalOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public static class Pos {
        int column;
        TreeNode node;
        public Pos(TreeNode node, int col) {
            this.column = col;
            this.node = node;
        }
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        // column ID : list of value 
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int minColumn = Integer.MAX_VALUE;
        int maxColumn = Integer.MIN_VALUE;
        LinkedList<Pos> q = new LinkedList<Pos>();
        q.offer(new Pos(root, 0));
        
        // BFS
        while (!q.isEmpty()) {
            Pos p = q.poll();
            minColumn = Math.min(minColumn, p.column);
            maxColumn = Math.max(maxColumn, p.column);
            if (!map.containsKey(p.column)) {
                map.put(p.column, new ArrayList<Integer>());
            }
            map.get(p.column).add(p.node.val);
            if (p.node.left != null) {
                q.add(new Pos(p.node.left, p.column - 1));
            }
            if (p.node.right != null) {
                q.add(new Pos(p.node.right, p.column + 1));
            }
        }

        // traverse the map and add to res
        for (int i = minColumn; i <= maxColumn; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        
        return res;
    }

}
