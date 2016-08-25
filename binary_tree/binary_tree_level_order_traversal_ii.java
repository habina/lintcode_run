package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class binary_tree_level_order_traversal_ii {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // bfs way
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        q.add(root);
        int curLevelNum = 1;
        int nextLevelNum = 0;
        
        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();
            curLevelNum--;
            if (curNode != null) {
                row.add(curNode.val);
                q.offer(curNode.left);
                q.offer(curNode.right);
                nextLevelNum += 2;
            }
            
            if (q.isEmpty()) {
                break;
            }
            
            // this level is done.
            if (curLevelNum == 0) {
                res.add(0, row);
                row = new ArrayList<Integer>();
                curLevelNum = nextLevelNum;
                nextLevelNum = 0;
            }
        }
        
        return res;
    }
    
//    /**
//     * @param root: The root of binary tree.
//     * @return: buttom-up level order a list of lists of integer
//     */
//    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
//        // dfs way
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        
//        int depth = maxDepth(root);
//        for (int i = 0; i < depth; i++) {
//            res.add(new ArrayList<Integer>());
//        }
//        dfs(root, res, depth - 1);
//        return res;
//    }
    
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    public static void dfs(TreeNode root, ArrayList<ArrayList<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, res, level - 1);
        dfs(root.right, res, level - 1);
        res.get(level).add(root.val);
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
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = four;
        rootRight.right = five;

        System.out.println(levelOrderBottom(root));
    }

}
