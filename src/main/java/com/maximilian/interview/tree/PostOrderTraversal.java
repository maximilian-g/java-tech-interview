package com.maximilian.interview.tree;

import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversal {

    public static List<Integer> postorderTraversal(TreeNode<Integer> root) {
        List<Integer> result = new LinkedList<>();
        traverse(root, result);
        return result;
    }

    private static void traverse(TreeNode<Integer> node, List<Integer> result) {
        if (node == null) {
            return;
        }
        traverse(node.left, result);
        traverse(node.right, result);
        result.add(node.val);
    }

}
