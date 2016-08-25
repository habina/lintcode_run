package binary_tree;

public class construct_binary_tree_from_inorder_and_postorder_traversal {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // 5
        // 2 7
        // 1 3 6 8
        // preorder: 5 2 1 3 7 6 8
        // inorder: 1 2 3 5 6 7 8
        // postorder: 1 3 2 6 8 7 5
        
        if (inorder.length != postorder.length) {
            return null;
        }

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = findRootIndex(inorder, inStart, inEnd, rootVal);
        int leftCount = rootIndex - inStart;
        
        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftCount - 1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postStart + leftCount, postEnd - 1);
        
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
        int[] inorder = { 1, 2, 3 };
        int[] postorder = { 1, 3, 2 };

        printBST(buildTree(inorder, postorder), "");
    }

}
