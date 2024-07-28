package com.maximilian.interview.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/leaf-similar-trees/description">
 * Link to a task</a>
 * <p>
 * Consider all the leaves of a binary tree, from left to right order,
 * the values of those leaves form a leaf value sequence.
 * <p>
 * Return true if and only if the two given trees with head nodes root1
 * and root2 are leaf-similar.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
 */
public class LeafSimilarTrees {

    public static boolean leafSimilar(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        List<Integer> firstList = new LinkedList<>();
        collectLeafsFromLeftToRight(root1, firstList);
        List<Integer> secondList = new LinkedList<>();
        collectLeafsFromLeftToRight(root2, secondList);
        return firstList.equals(secondList);
    }

    private static void collectLeafsFromLeftToRight(TreeNode<Integer> root,
                                                    List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        collectLeafsFromLeftToRight(root.left, result);
        collectLeafsFromLeftToRight(root.right, result);
    }

}
