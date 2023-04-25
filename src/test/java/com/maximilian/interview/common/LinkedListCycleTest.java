package com.maximilian.interview.common;

import com.maximilian.interview.stack.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListCycleTest {

    @Test
    void hasCycle() {

        Node<Integer> head = new Node<>(5, new Node<>(10, new Node<>(15)));

        Assertions.assertFalse(LinkedListCycle.hasCycle(head));

        head.next.next = head;
        Assertions.assertTrue(LinkedListCycle.hasCycle(head));

        Assertions.assertFalse(LinkedListCycle.hasCycle(null));

        head.next = head;
        Assertions.assertTrue(LinkedListCycle.hasCycle(head));

    }

}