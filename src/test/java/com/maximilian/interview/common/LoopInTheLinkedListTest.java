package com.maximilian.interview.common;

import com.maximilian.interview.stack.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoopInTheLinkedListTest {

    @Test
    void containsLoop() {

        Node<Integer> tmp = new Node<>(5);
        tmp.next = tmp;

        Assertions.assertTrue(LoopInTheLinkedList.containsLoop(tmp));
        tmp.next = new Node<>(10, new Node<>(20, tmp));
        Assertions.assertTrue(LoopInTheLinkedList.containsLoop(tmp));

        tmp.next = new Node<>(10, new Node<>(20));
        Assertions.assertFalse(LoopInTheLinkedList.containsLoop(tmp));
        Assertions.assertFalse(LoopInTheLinkedList.containsLoop(null));

    }

}