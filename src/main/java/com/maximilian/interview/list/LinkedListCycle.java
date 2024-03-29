package com.maximilian.interview.list;

import com.maximilian.interview.stack.Node;

import java.util.HashSet;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be
 * reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {

    public static <T> boolean hasCycle(Node<T> head) {
        if (head == null) {
            return false;
        }
        HashSet<Node<T>> set = new HashSet<>();
        Node<T> current = head;
        set.add(current);
        while ((current = current.next) != null) {
            if (set.contains(current)) {
                return true;
            }
            set.add(current);
        }
        return false;
    }

}
