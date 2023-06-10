package com.maximilian.interview.tree;

/**
 * Given the roots of two binary trees root and subRoot, return true if there is
 * a subtree of root with the same structure and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree is a tree that consists of a node in tree and
 * all of this node's descendants. The tree could also be considered as a subtree of itself.
 * <p>
 * Examples:
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * <p>
 * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * Output: false
 */
public class SubtreeOfAnotherTree {

    // O(n)
    public static boolean isSubtree(TreeNode<Integer> root, TreeNode<Integer> subRoot) {
        if (root == null) {
            return false;
        }
        boolean isSubTreeLeft = isSubtree(root.left, subRoot);
        boolean isSubTreeRight = isSubtree(root.right, subRoot);

        return SameTree.isSameTree(root, subRoot) || isSubTreeLeft || isSubTreeRight;
    }

}
