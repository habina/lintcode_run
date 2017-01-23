package com.google.phone;

public class SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb); 
        return sb.toString();
    }
    
    public void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(" ");
            return;
        }
        sb.append(node.val).append(" ");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = {0};
        return dfs(data.split(" "), index);
    }
    
    public TreeNode dfs(String[] data, int[] index) {
        if (data[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(data[index[0]]));
        index[0]++;
        node.left = dfs(data, index);
        node.right = dfs(data, index);
        
        return node;
    }
    
    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree sadbt = new SerializeAndDeserializeBinaryTree();
        String s = sadbt.serialize(new TreeNode(1));
        System.out.println(s);
    }

}
