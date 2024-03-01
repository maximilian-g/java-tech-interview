package com.maximilian.interview.tree;

/**
 * You are given the root node of a binary search tree (BST) and
 * a value to insert into the tree. Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 * <p>
 * Notice that there may exist multiple valid ways for the insertion,
 * as long as the tree remains a BST after insertion. You can return any of them.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree will be in the range [0, 104].
 * -10^8 <= Node.val <= 10^8
 * All the values Node.val are unique.
 * -10^8 <= val <= 108
 * It's guaranteed that val does not exist in the original BST.
 */
public class InsertIntoBST {

    public static TreeNode<Integer> insertIntoBST(TreeNode<Integer> root, int val) {
        if (root == null) {
            root = new TreeNode<>(val);
            return root;
        }
        insertIntoBinarySearchTree(root, val);
        return root;
    }

    private static void insertIntoBinarySearchTree(TreeNode<Integer> currentNode, int val) {
        if (currentNode.val > val) {
            if (currentNode.left != null) {
                insertIntoBinarySearchTree(currentNode.left, val);
            } else {
                currentNode.left = new TreeNode<>(val);
            }
        } else {
            if (currentNode.right != null) {
                insertIntoBinarySearchTree(currentNode.right, val);
            } else {
                currentNode.right = new TreeNode<>(val);
            }
        }
    }

}
