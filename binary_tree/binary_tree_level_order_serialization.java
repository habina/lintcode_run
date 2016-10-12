package binary_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class binary_tree_level_order_serialization {

    public static class TreeNode {
        public char val;
        public int level;
        public TreeNode left, right;

        public TreeNode(char val, int level) {
            this.val = val;
            this.level = level;
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
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    continue;
                }

                sb.append(cur.val);
                sb.append(level);
                q.offer(cur.left);
                q.offer(cur.right);
            }
            level++;
        }

        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly you
     * serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        data = data.trim();
        String[] sp1 = data.split("\\d");
        String[] sp2 = data.substring(1).split("[a-zA-Z]");
        char[] nodes = new char[sp1.length];
        int[] level = new int[sp2.length];
        for (int i = 0; i < sp1.length; i++) {
            nodes[i] = sp1[i].charAt(0);
        }
        for (int i = 0; i < sp2.length; i++) {
            level[i] = Character.getNumericValue(sp2[i].charAt(0));
        }
        
        TreeNode root = new TreeNode(nodes[0], level[0]);
        int i = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            boolean hasLeft = false;
            
            if (i < nodes.length && level[i] == cur.level + 1) {
                hasLeft = true;
                cur.left = new TreeNode(nodes[i], level[i]);
                q.offer(cur.left);
                i++;
            }
            
            if (hasLeft && i < nodes.length && level[i] == cur.level + 1) {
                cur.right = new TreeNode(nodes[i], level[i]);
                q.offer(cur.right);
                i++;
            }
        }

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
        TreeNode root = new TreeNode('a', 0);
        TreeNode rootLeft = new TreeNode('b', 1);
        TreeNode rootRight = new TreeNode('c', 1);
        TreeNode four = new TreeNode('d', 2);
        TreeNode five = new TreeNode('e', 2);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = four;
        rootLeft.right = five;

        printBST(root, "");
        System.out.println(serialize(root));
        printBST(deserialize(serialize(root)), "");
    }

}
