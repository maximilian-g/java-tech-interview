package com.maximilian.interview.list;

import com.maximilian.interview.stack.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Find loop in the linked list
 */
public class LoopInTheLinkedList {

    public static <T> boolean containsLoop(Node<T> root) {
        Set<Node<T>> set = new HashSet<>();
        while (root != null) {
            if (set.contains(root)) {
                return true;
            }
            set.add(root);
            root = root.next;
        }
        return false;
    }

}
