package com.google.phone;

public class BinaryTreeLongestConsecutiveSequence {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }
    
    public static int dfs(TreeNode root, int len) {
        if (root == null) {
            return 0;
        }
        int left = 1;
        int right = 1;
        if (root.left != null) {
            if (root.val + 1 == root.left.val) {
                left = dfs(root.left, len + 1);
            } else {
                left = dfs(root.left, 0);
            }
        }
        if (root.right != null) {
            if (root.val + 1 == root.right.val) {
                right = dfs(root.right, len + 1);
            } else {
                right = dfs(root.right, 0);
            }
        }
        
        return Math.max(Math.max(left, right), len);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        root.right = three;
        three.left = two;
        three.right = four;
        four.right = five;
        System.out.println(longestConsecutive(root));
    }

}
