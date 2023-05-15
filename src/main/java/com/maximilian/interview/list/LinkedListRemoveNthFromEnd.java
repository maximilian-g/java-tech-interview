package com.maximilian.interview.list;

import com.maximilian.interview.stack.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class LinkedListRemoveNthFromEnd {

    public static <T> Node<T> removeNthFromEnd(Node<T> head, int n) {
        List<Node<T>> nodeList = new ArrayList<>(30);
        Node<T> current = head;
        nodeList.add(current);
        while ((current = current.next) != null) {
            nodeList.add(current);
        }

        int index = nodeList.size() - n;

        if (index == 0) {
            if (nodeList.size() > 1) {
                head = nodeList.get(1);
            } else {
                head = null;
            }
        } else if (index > 0) {
            if (index + 1 < nodeList.size()) {
                nodeList.get(index - 1).next = nodeList.get(index + 1);
            } else {
                // case when we do not have
                nodeList.get(index - 1).next = null;
            }
        }

        return head;
    }

}
