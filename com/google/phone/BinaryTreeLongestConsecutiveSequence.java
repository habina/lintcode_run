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
        return dfs(root, 1);
    }

    public static int dfs(TreeNode node, int lenSoFar) {
        if (node == null) {
            return lenSoFar;
        }
        int leftLength = lenSoFar;
        int rightLength = lenSoFar;
        if (node.left != null) {
            if (node.left.val == node.val + 1) {
                leftLength = dfs(node.left, lenSoFar + 1);
            } else {
                leftLength = Math.max(lenSoFar, dfs(node.left, 1));
            }
        }
        if (node.right != null) {
            if (node.right.val == node.val + 1) {
                rightLength = dfs(node.right, lenSoFar + 1);
            } else {
                rightLength = Math.max(lenSoFar, dfs(node.right, 1));
            }
        }
        lenSoFar = Math.max(leftLength, rightLength);

        return lenSoFar;
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
