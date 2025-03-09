package com.maximilian.interview.list;

import com.maximilian.interview.stack.Node;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/description/">Link to a task</a>
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4]
 * <p>
 * Output: [2,1,4,3]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
public class SwapNodesInPairs {

    public static Node<Integer> swapPairs(Node<Integer> head) {

        Node<Integer> result = null;
        Node<Integer> prev = null;
        Node<Integer> prevPairEnd = null;
        while (head != null && head.next != null) {
            prev = head.next;
            if (result == null) {
                result = prev;
            }
            head.next = prev.next;
            prev.next = head;
            if (prevPairEnd != null) {
                prevPairEnd.next = prev;
            }
            prevPairEnd = head;
            head = head.next;
        }
        if (result == null) {
            result = head;
        }

        return result;
    }

}
