package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class binary_tree_level_order_traversal {

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
     * @return: Level order a list of lists of integer
     */
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // use dfs
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        dfs(root, res, 0);
        return res;
    }
    
    public static void dfs(TreeNode root, ArrayList<ArrayList<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }

//    /**
//     * @param root:
//     *            The root of binary tree.
//     * @return: Level order a list of lists of integer
//     */
//    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
//        // using queue, breadth first search
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//
//        if (root == null) {
//            return res;
//        }
//
//        Queue<TreeNode> q = new LinkedList<TreeNode>();
//        ArrayList<Integer> row = new ArrayList<Integer>();
//        q.offer(root);
//        int curLevelNum = 1;
//        int nextLevelNum = 0;
//
//        while (!q.isEmpty()) {
//            TreeNode cur = q.poll();
//            curLevelNum--;
//            if (cur != null) {
//                row.add(cur.val);
//                q.offer(cur.left);
//                q.offer(cur.right);
//                nextLevelNum += 2;
//            }
//
//            if (q.isEmpty()) {
//                break;
//            }
//
//            if (curLevelNum == 0) {
//                res.add(row);
//                curLevelNum = nextLevelNum;
//                row = new ArrayList<Integer>();
//                nextLevelNum = 0;
//            }
//        }
//        
//        return res;
//    }

    public static void printBST(TreeNode root, String prefix) {
        if (root == null) {
            return;
        }

        System.out.println(prefix + root.val);
        printBST(root.left, prefix + "---");
        printBST(root.right, prefix + "---");
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

        System.out.println(levelOrder(root));
    }

}
