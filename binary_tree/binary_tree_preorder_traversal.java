package binary_tree;

import java.util.ArrayList;
import java.util.Stack;

public class binary_tree_preorder_traversal {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root:
     *            The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
//    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        // recursive way
        // runtime: n, space: logn
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        if (root == null) {
//            return res;
//        }
//        res.addAll(inorderTraversal(root.left));
//        res.add(root.val);
//        res.addAll(inorderTraversal(root.right));
//        return res;
//    }

    /**
     * @param root:
     *            The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
//    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        // deconstructive way, break tree's structure
        // runtime: n, space: logn
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        if (root == null) {
//            return res;
//        }
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode peek = stack.peek();
//            if (peek.left != null) {
//                stack.push(peek.left);
//                // mark left as checked.
//                peek.left = null;
//            } else {
//                res.add(peek.val);
//                stack.pop();
//                if (peek.right != null) {
//                    stack.push(peek.right);
//                }
//            }
//        }
//
//        return res;
//    }

    /**
     * @param root:
     *            The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
//    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        // non-recusive way and maintain tree's structure
        // runtime: n, space: logn
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//
//        while (root != null || !stack.isEmpty()) {
//            if (root != null) {
//                stack.push(root);
//                root = root.left;
//            } else {
//                root = stack.pop();
//                res.add(root.val);
//                root = root.right;
//            }
//        }
//
//        return res;
//    }
    
    /**
     * @param root:
     *            The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        // morris traversal
        // basically the idea behind this is connecting the predecessor to the current node
        // so you can fast locate the current node back.
        // ref: http://blog.csdn.net/linhuanmars/article/details/20187257
        // runtime: n, space: 1
        ArrayList<Integer> res = new ArrayList<Integer>();

        while (root != null) {
            if (root.left == null) {
                // most easy case, no left subtree
                // visit cur node and go right
                res.add(root.val);
                root = root.right;
            } else {
                TreeNode predecessor = findPredecessor(root);
                if (predecessor.right == root) {
                    // this means all the left subtree of root are visited.
                    // we can visit cur node now.
                    res.add(root.val);
                    // recover tree structure
                    predecessor.right = null;
                    // keep going to right
                    root = root.right;
                } else {
                    // connect the predecessor
                    predecessor.right = root;
                    // keep goint to left
                    root = root.left;
                }
            }
        }

        return res;
    }
    
    public static TreeNode findPredecessor(TreeNode root) {
        TreeNode cur = root.left;
        while (cur.right != null && cur.right != root) {
            cur = cur.right;
        }
        return cur;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = four;
        rootRight.right = five;

        System.out.println(inorderTraversal(root));
    }

}
