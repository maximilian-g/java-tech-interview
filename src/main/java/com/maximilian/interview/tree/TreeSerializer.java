package com.maximilian.interview.tree;

public class TreeSerializer {

    public static final String NULL_PRT_STR = "N";
    // not thread safe
    private int i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode<Integer> root) {
        StringBuilder builder = new StringBuilder();
        preorderTraverse(root, builder);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode<Integer> deserialize(String data) {
        i = 0;
        String[] split = data.split(",");
        return deserializeDFS(split);
    }

    private TreeNode<Integer> deserializeDFS(String[] tokens) {
        String token = tokens[this.i];
        if (NULL_PRT_STR.equals(token)) {
            this.i++;
            return null;
        }
        TreeNode<Integer> node = new TreeNode<>(Integer.parseInt(token));
        this.i++;
        node.left = deserializeDFS(tokens);
        node.right = deserializeDFS(tokens);
        return node;
    }

    private void preorderTraverse(TreeNode<Integer> root, StringBuilder builder) {
        if (!builder.isEmpty()) {
            builder.append(',');
        }
        if (root == null) {
            builder.append(NULL_PRT_STR);
            return;
        }
        builder.append(root.val);
        preorderTraverse(root.left, builder);
        preorderTraverse(root.right, builder);
    }

}
