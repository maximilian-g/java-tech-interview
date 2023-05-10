package com.maximilian.interview.common;

import com.maximilian.interview.stack.Node;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 */
public class ReorderList {

    public static <T> void reorderList(Node<T> head) {
        if (head == null ||
                head.next == null ||
                head.next.next == null) {
            return;
        }

        // finding middle of list
        Node<T> fastPointer = head;
        Node<T> mid = head;
        while (fastPointer != null && fastPointer.next != null) {
            mid = mid.next;
            fastPointer = fastPointer.next.next;
        }

        Node<T> newMid = ReverseLinkedList.reverseList(mid);

        Node<T> temp = new Node<>(head.val);

        while (head != mid && newMid != null) {
            temp.next = head;
            head = head.next;
            temp = temp.next;
            temp.next = newMid;
            newMid = newMid.next;
            temp = temp.next;
        }
    }

}
