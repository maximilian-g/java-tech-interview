package com.maximilian.interview.list;

import com.maximilian.interview.stack.Node;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * Constraints:
 * <p>
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 */
public class ReverseKGroup {

    public static <T> Node<T> reverseKGroup(Node<T> head, int k) {
        if (k == 1) {
            return head;
        }
        Node<T> resHead = null;
        Node<T> prevForKNodes = null;
        Node<T> headForKNodes = null;
        int i = 0;
        while (head != null) {
            if ((i + 1) % k == 0) {
                Node<T> temp = head.next;
                head.next = null;
                head = ReverseLinkedList.reverseList(headForKNodes);
                if (prevForKNodes != null) {
                    prevForKNodes.next = head;
                } else {
                    resHead = head;
                }
                while (head.next != null) {
                    head = head.next;
                }
                head.next = temp;
                prevForKNodes = head;
                headForKNodes = head.next;
            }
            if (headForKNodes == null) {
                headForKNodes = head;
            }
            i++;
            head = head.next;
        }

        return resHead;
    }

}
