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
    
//    /**
//     * @param root: The root of binary tree.
//     * @return: Preorder in ArrayList which contains node values.
//     */
//    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        if (root == null) {
//            return res;
//        }
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode cur = stack.pop();
//            res.add(cur.val);
//            if (cur.right != null) {
//                stack.push(cur.right);
//            }
//            if (cur.left != null) {
//                stack.push(cur.left);
//            }
//        }
//
//        return res;
//    }
    
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) { 
            return res;
        }
        
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
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

        System.out.println(preorderTraversal(root));
    }

}
