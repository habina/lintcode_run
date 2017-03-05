package com.facebook.phone;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        dfs(0, res, root);
        return res;
    }
    
    public void dfs(int level, ArrayList<ArrayList<Integer>> res, TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        
        res.get(level).add(root.val);
        dfs(level + 1, res, root.left);
        dfs(level + 1, res, root.right);
    }

}
