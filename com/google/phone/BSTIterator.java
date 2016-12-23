package com.google.phone;

import java.util.ArrayList;
import java.util.Stack;

public class BSTIterator {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Stack<TreeNode> stack;

    // @param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        pushLeft(root);
    }

    // @return: True if there has next node, or false
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // @return: return next node
    public TreeNode next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeft(node.right);
        }
        return node;
    }

    public void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = left;
        left.right = right;

        BSTIterator iter = new BSTIterator(root);
        while (iter.hasNext()) {
            System.out.println(iter.next().val);
        }
    }
}