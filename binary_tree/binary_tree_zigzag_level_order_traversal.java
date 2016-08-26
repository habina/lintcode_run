package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class binary_tree_zigzag_level_order_traversal {
    

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // bfs way.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        
        q.offer(root);
        int curLevelNum = 1;
        int nextLevelNum = 0;
        boolean isNormal = true;
        
        while(!q.isEmpty()) {
            TreeNode curNode = q.poll();
            curLevelNum--;
            if (curNode != null) {
                if (isNormal) {
                    row.add(curNode.val);
                } else {
                    row.add(0, curNode.val);
                }
                q.offer(curNode.left);
                q.offer(curNode.right);
                nextLevelNum += 2;
            }
            if (q.isEmpty()) {
                break;
            }
            if (curLevelNum == 0) {
                isNormal = !isNormal;
                res.add(row);
                row = new ArrayList<Integer>();
                curLevelNum = nextLevelNum;
                nextLevelNum = 0;
            }
        }
        
        return res;
    }
    
//    /**
//     * @param root: The root of binary tree.
//     * @return: A list of lists of integer include 
//     *          the zigzag level order traversal of its nodes' values 
//     */
//    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
//        // dfs way.
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        dfs(root, res, 0);
//        return res;
//    }

    public static void dfs(TreeNode root, ArrayList<ArrayList<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
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
        
        System.out.println(zigzagLevelOrder(root));
    }

}
