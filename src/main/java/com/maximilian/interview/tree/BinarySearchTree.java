package com.maximilian.interview.tree;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void insert(T val) {
        if (root == null) {
            root = new TreeNode<>();
            root.val = val;
            return;
        }
        TreeNode<T> current = root;
        int comparisonValue;
        boolean placeIsFoundOrEquals = false;
        while (!placeIsFoundOrEquals) {
            comparisonValue = val.compareTo(current.val);
            if (comparisonValue > 0) {
                if (current.right == null) {
                    current.right = new TreeNode<>();
                    current.right.val = val;
                    placeIsFoundOrEquals = true;
                }
                current = current.right;
            } else if (comparisonValue < 0) {
                if (current.left == null) {
                    current.left = new TreeNode<>();
                    current.left.val = val;
                    placeIsFoundOrEquals = true;
                }
                current = current.left;
            } else {
                // equals case
                placeIsFoundOrEquals = true;
            }
        }
    }

    public boolean contains(T val) {
        if (root == null) {
            return false;
        }
        TreeNode<T> current = root;
        int comparisonValue;
        while (current != null) {
            comparisonValue = val.compareTo(current.val);
            if (comparisonValue > 0) {
                current = current.right;
            } else if (comparisonValue < 0) {
                current = current.left;
            } else {
                // equals case
                return true;
            }
        }
        return false;
    }

    // bfs
    public void bfsTraversal() {
        if (root == null) {
            return;
        }
        TreeNode<T> current = root;
        List<TreeNode<T>> nodes = new LinkedList<>();
        List<TreeNode<T>> nodesTemp = new LinkedList<>();
        nodes.add(current);

        while (!nodes.isEmpty()) {
            for (TreeNode<T> node : nodes) {
                if (node != null) {
                    System.out.println(node.val);
                    nodesTemp.add(node.left);
                    nodesTemp.add(node.right);
                }
            }
            nodes = nodesTemp;
            nodesTemp = new LinkedList<>();
        }

    }

    public void print() {
        printInternal(root);
    }

    public List<T> getValuesAsList() {
        List<T> values = new LinkedList<>();
        fillList(root, values);
        return values;
    }

    // binary tree is not usable after invert
    public void invert() {
        invertInternal(root);
    }

    // dfs
    private void printInternal(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        printInternal(node.left);
        System.out.println(node.val);
        printInternal(node.right);
    }

    private void fillList(TreeNode<T> node, List<T> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        fillList(node.left, result);
        fillList(node.right, result);
    }

    private TreeNode<T> invertInternal(TreeNode<T> root) {
        if (root == null) {
            return null;
        }
        TreeNode<T> tmp = invertInternal(root.right);
        root.right = invertInternal(root.left);
        root.left = tmp;
        return root;
    }

}
