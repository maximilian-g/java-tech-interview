package com.maximilian.interview.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description">
 * Link to a task</a>
 * <p>
 * Given the root of a binary tree, the level of its root is 1,
 * the level of its children is 2, and so on.
 * <p>
 * Return the smallest level x such that the sum of all the values of
 * nodes at level x is maximal.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^5 <= Node.val <= 10^5
 */
public class MaximumLevelSumBinaryTree {

    public static int maxLevelSum(TreeNode<Integer> root) {
        int maxLevel = 0;
        int currentLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        List<TreeNode<Integer>> levelElements = new LinkedList<>();
        List<TreeNode<Integer>> levelElementsTemp = new LinkedList<>();
        levelElements.add(root);

        while (!levelElements.isEmpty()) {
            int localMaxSum = 0;
            for (TreeNode<Integer> levelElement : levelElements) {
                if (levelElement.left != null) {
                    levelElementsTemp.add(levelElement.left);
                }
                if (levelElement.right != null) {
                    levelElementsTemp.add(levelElement.right);
                }
                localMaxSum += levelElement.val;
            }
            if (localMaxSum > maxSum) {
                maxSum = localMaxSum;
                maxLevel = currentLevel;
            }
            currentLevel++;
            levelElements = levelElementsTemp;
            levelElementsTemp = new LinkedList<>();
        }
        return maxLevel;
    }

}
