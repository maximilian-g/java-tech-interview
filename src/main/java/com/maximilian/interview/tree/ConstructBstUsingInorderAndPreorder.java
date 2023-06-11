package com.maximilian.interview.tree;

import java.util.Arrays;

/**
 * Given two integer arrays preorder and inorder where preorder
 * is the preorder traversal of a binary tree and inorder
 * is the inorder traversal of the same tree,
 * construct and return the binary tree.
 */
public class ConstructBstUsingInorderAndPreorder {

    public static TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(preorder[0]);

        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                mid = i;
                break;
            }
        }

        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(inorder, 0, mid)
        );
        root.right = buildTree(
                Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length)
        );

        return root;
    }

}
