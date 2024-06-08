package com.maximilian.interview.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return an array
 * of the largest value in each row of the tree (0-indexed).
 */
public class FindLargestValueInEachTreeRow {

    public static List<Integer> largestValues(TreeNode<Integer> root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode<Integer>> nodesList = new LinkedList<>();
        nodesList.add(root);
        List<TreeNode<Integer>> nodesListTemp = new LinkedList<>();

        int maxInteger = Integer.MIN_VALUE;
        while (!nodesList.isEmpty()) {
            for (TreeNode<Integer> integerTreeNode : nodesList) {
                maxInteger = Math.max(integerTreeNode.val, maxInteger);
                if (integerTreeNode.left != null) {
                    nodesListTemp.add(integerTreeNode.left);
                }
                if (integerTreeNode.right != null) {
                    nodesListTemp.add(integerTreeNode.right);
                }
            }
            result.add(maxInteger);
            maxInteger = Integer.MIN_VALUE;
            nodesList = nodesListTemp;
            nodesListTemp = new LinkedList<>();
        }
        return result;
    }

}
