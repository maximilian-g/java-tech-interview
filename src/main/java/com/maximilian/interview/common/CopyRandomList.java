package com.maximilian.interview.common;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y,
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 * or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * <p>
 * Constraints:
 * 0 <= n <= 1000
 */
public class CopyRandomList {

    public static <T> RandomNode<T> copyRandomList(RandomNode<T> head) {
        RandomNode<T> result = null;
        List<RandomNode<T>> nodeByIndexInitial = new ArrayList<>(1000);
        List<RandomNode<T>> nodeByIndexResult = new ArrayList<>(1000);
        while (head != null) {
            if (result == null) {
                result = new RandomNode<>(head.val);
            } else {
                result.next = new RandomNode<>(head.val);
            }
            nodeByIndexInitial.add(head);
            head = head.next;

            if (result.next != null) {
                result = result.next;
            }
            nodeByIndexResult.add(result);
        }

        Map<Integer, Integer> randomNodesMap = new HashMap<>();
        for (int i = 0; i < nodeByIndexInitial.size(); i++) {
            RandomNode<T> node = nodeByIndexInitial.get(i);
            if (node.random == null) {
                randomNodesMap.put(i, null);
            } else {
                randomNodesMap.put(i, getNodeIndexOf(node.random, nodeByIndexInitial));
            }
        }

        for (Map.Entry<Integer, Integer> entry : randomNodesMap.entrySet()) {
            nodeByIndexResult.get(entry.getKey()).random = entry.getValue() == null ?
                    null : nodeByIndexResult.get(entry.getValue());
        }


        return nodeByIndexResult.size() > 0 ? nodeByIndexResult.get(0) : null;
    }

    private static <T> int getNodeIndexOf(RandomNode<T> node, List<RandomNode<T>> nodeByIndex) {
        for (int i = 0; i < nodeByIndex.size(); i++) {
            RandomNode<T> item = nodeByIndex.get(i);
            if (item == node) {
                return i;
            }
        }
        return -1;
    }

    public static class RandomNode<T> {
        public RandomNode<T> random;
        public T val;
        public RandomNode<T> next;

        public RandomNode(T val) {
            this.val = val;
            this.next = null;
        }

        public RandomNode(T val, RandomNode<T> next) {
            this.val = val;
            this.next = next;
        }

    }

}
