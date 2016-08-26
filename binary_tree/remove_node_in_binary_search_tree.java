package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class remove_node_in_binary_search_tree {
    

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public static TreeNode removeNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (value < root.val) {
            root.left = removeNode(root.left, value);
        } else if (value > root.val) {
            root.right = removeNode(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode newRoot = findMin(root.right);
                newRoot.right = deleteMin(root.right);
                newRoot.left = root.left;
                return newRoot;
            }
        }
        return root;
    }
    
    public static TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }
    
    public static TreeNode deleteMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return null;
        }
        
        root.left = deleteMin(root.left);
        return root;
    }
    
    public static void printBST(TreeNode root, String prefix) {
        if (root == null) {
            return;
        }

        System.out.println(prefix + root.val);
        printBST(root.left, prefix + "---");
        printBST(root.right, prefix + "---");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode rootLeft = new TreeNode(5);
        TreeNode rootRight = new TreeNode(15);
        TreeNode four = new TreeNode(6);
        TreeNode five = new TreeNode(20);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.right = four;
        rootRight.right = five;
        
        printBST(root, "");
        printBST(removeNode(root, 5), "");
    }

}
