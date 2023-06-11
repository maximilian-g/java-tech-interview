package com.maximilian.interview.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode<Integer> root) {
        List<List<Integer>> levels = LevelOrderTraversal.levelOrder(root);
        List<Integer> res = new ArrayList<>(levels.size());
        for (List<Integer> level : levels) {
            res.add(level.get(level.size() - 1));
        }
        return res;
    }

}
