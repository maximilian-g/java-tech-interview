package com.maximilian.interview.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given the root of a binary tree, return the bottom-up level order
 * traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/">Link to task</a>
 */
public class LevelOrderTraversalReversed {

    // not thread safe impl
    private static int level = 0;

    public static List<List<Integer>> levelOrderBottom(TreeNode<Integer> root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
        traverseByLevel(map, root);
        return new ArrayList<>(map.values());
    }

    private static void traverseByLevel(Map<Integer, List<Integer>> levelMap,
                                 TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        level++;
        traverseByLevel(levelMap, root.left);
        if (!levelMap.containsKey(level)) {
            levelMap.put(level, new LinkedList<>());
        }
        levelMap.get(level).add(root.val);
        traverseByLevel(levelMap, root.right);
        level--;
    }

}
