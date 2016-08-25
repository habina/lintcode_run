package binary_tree;

public class validate_binary_search_tree {

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
     * @return: True if the binary tree is BST, or false
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val > min && root.val < max) {
            return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
        } else {
            return false;
        }
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
        rootRight.left = four;
        rootRight.right = five;

        printBST(root, "");
        System.out.println(isValidBST(root));
    }

}
