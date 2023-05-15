package com.maximilian.interview.list;

import com.maximilian.interview.stack.Node;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public static <T> Node<T> reverseList(Node<T> head) {
        if (head == null) {
            return null;
        }
        Node<T> newHead = null;
        Node<T> previousElement = null;
        while (head != null) {
            newHead = new Node<>(head.val, newHead == null ? null : previousElement);
            previousElement = newHead;
            head = head.next;
        }
        return newHead;
    }

}
