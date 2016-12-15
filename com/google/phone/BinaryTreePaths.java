package com.google.phone;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root
     *            the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        dfs(root, res, String.valueOf(root.val)); 
        return res;
    }
    
    public void dfs(TreeNode node, List<String> res, String cur) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            res.add(cur);
        }
        
        if (node.left != null) {
            dfs(node.left, res, cur + "->" + node.left.val);
        }
        
        if (node.right != null) {
            dfs(node.right, res, cur + "->" + node.right.val);
        }
    }

}
