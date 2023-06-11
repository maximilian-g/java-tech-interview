package com.maximilian.interview.tree;

/**
 * Given the root of a binary tree, return the level order traversal
 * of its nodes' values. (i.e., from left to right, level by level).
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given the root of a binary tree, return the level
 * order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class LevelOrderTraversal {

    // not thread safe impl
    private static int level = 0;

    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
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
