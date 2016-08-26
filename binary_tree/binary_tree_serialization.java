package binary_tree;

import java.util.ArrayList;

public class binary_tree_serialization {
    

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "# ";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + " ");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
        data = data.trim();
        String[] nodes = data.split(" ");
        
        int[] curNode = {0};
        return deserialize(nodes, curNode);
    }
    
    public static TreeNode deserialize(String[] nodes, int[] curNode) {

        if (curNode[0] >= nodes.length) {
            return null;
        }
        if (nodes[curNode[0]].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[curNode[0]]));
        curNode[0]++;
        root.left = deserialize(nodes, curNode);
        curNode[0]++;
        root.right = deserialize(nodes, curNode);

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
        System.out.println(serialize(root));
        printBST(deserialize(serialize(root)), "");
    }

}
