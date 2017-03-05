package com.facebook.phone;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        dfs(res, "", root);
        return res;
    }
    
    public void dfs(List<String> res, String path, TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            path += root.val;
            res.add(path);
        } else {
            path += root.val + "->";
            if (root.left != null) {
                dfs(res, path, root.left);
            }
            if (root.right != null) {
                dfs(res, path, root.right);
            }
        }
    }

}
