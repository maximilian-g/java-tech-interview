package com.maximilian.interview.list;

import com.maximilian.interview.stack.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwapNodesInPairsTest {

    @Test
    void swapPairs() {

        Node<Integer> head = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4))));
        Node<Integer> expected = new Node<>(2, new Node<>(1, new Node<>(4, new Node<>(3))));

        Node<Integer> result = SwapNodesInPairs.swapPairs(head);
        Assertions.assertNotNull(result);
        while (expected != null) {
            Assertions.assertNotNull(result);
            Assertions.assertEquals(expected.val, result.val);
            expected = expected.next;
            result = result.next;
        }

    }

}