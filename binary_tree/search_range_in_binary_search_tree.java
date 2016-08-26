package binary_tree;

import java.util.ArrayList;

public class search_range_in_binary_search_tree {
    

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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        dfs(root, k1, k2, res);
        return res;
    }
    
    public static void dfs(TreeNode root, int k1, int k2, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, k1, k2, res);
        if (root.val >= k1 && root.val <= k2) {
            res.add(root.val);
        }
        dfs(root.right, k1, k2, res);
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
        
        System.out.println(searchRange(root, 3, 13));
    }

}
