package binary_tree;

public class construct_binary_tree_from_preorder_and_inorder_traversal {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param preorder
     *            : A list of integers that preorder traversal of a tree
     * @param inorder
     *            : A list of integers that inorder traversal of a tree
     * @return : Root of a tree
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        // 5
        // 2 7
        // 1 3 6 8
        // preorder: 5 2 1 3 7 6 8
        // inorder: 1 2 3 5 6 7 8
        if (preorder.length != inorder.length) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = findRootIndex(inorder, inStart, inEnd, rootVal);
        int leftCount = rootIndex - inStart;
        
        root.left = buildTree(preorder, preStart + 1, preStart + leftCount, inorder, inStart, rootIndex - 1);

        root.right = buildTree(preorder, preStart + 1 + leftCount, preEnd, inorder, rootIndex + 1, inEnd);
        
        return root;
    }
    
    public static int findRootIndex(int[] inorder, int inStart, int inEnd, int rootVal) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        
        return -1;
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
        int[] preorder = { 2, 1, 3 };
        int[] inorder = { 1, 2, 3 };

        printBST(buildTree(preorder, inorder), "");
    }

}
