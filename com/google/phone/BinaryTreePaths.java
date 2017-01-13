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
        dfs(res, root, "");
        return res;
    }
    
    public void dfs(List<String> res, TreeNode root, String cur) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(cur + root.val);
            return;
        }
        
        cur = cur + root.val + "->";
        
        if (root.left != null) {
            dfs(res, root.left, cur);
        }
        if (root.right != null) {
            dfs(res, root.right, cur);
        }
    }

}
