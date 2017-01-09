package com.google.phone;

public class KthSmallestElementInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int leftCount;

        TreeNode(int x) {
            val = x;
        }
    }
    
//    public static int kthSmallest(TreeNode root, int k) {
//        // runtime: lg n
//        if (root == null) {
//            return -1;
//        }
//        if (k == root.leftCount + 1) {
//            return root.val;
//        } else if (k > root.leftCount) {
//            return kthSmallest(root.right, k - root.leftCount - 1);
//        } else {
//            return kthSmallest(root.left, k);
//        }
//    }

    public static int kthSmallest(TreeNode root, int k) {
        // runtime: k 
        int[] seq = {k};
        TreeNode node = inOrder(root, seq);
        return node.val;
    }
    
    public static TreeNode inOrder(TreeNode root, int[] seq) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = inOrder(root.left, seq);
        if (seq[0] == 0) {
            return left;
        }
        seq[0]--;
        if (seq[0] == 0) {
            return root;
        }
        return inOrder(root.right, seq);
    }
    
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        
        four.left = two;
        four.right = six;
        two.left = one;
        two.right = three;
        six.left = five;
        six.right = seven;
        
        for (int i = 1; i <= 7; i++) {
            System.out.println(kthSmallest(four, i));
        }
        
    }

}
