package com.maximilian.interview.common;

import com.maximilian.interview.stack.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LinkedListRemoveNthFromEndTest {

    @Test
    void removeNthFromEnd() {

        Node<Integer> head = new Node<>(1, new Node<>(2,
                new Node<>(3, new Node<>(4, new Node<>(5)))));

        head = LinkedListRemoveNthFromEnd.removeNthFromEnd(head, 2);
        List<Integer> listToVerify = List.of(1, 2, 3, 5);
        verify(head, listToVerify);

        head = LinkedListRemoveNthFromEnd.removeNthFromEnd(head, 2);
        listToVerify = List.of(1, 2, 5);
        verify(head, listToVerify);

        head = LinkedListRemoveNthFromEnd.removeNthFromEnd(head, 1);
        listToVerify = List.of(1, 2);
        verify(head, listToVerify);


        head = LinkedListRemoveNthFromEnd.removeNthFromEnd(head, 2);
        listToVerify = List.of(2);
        verify(head, listToVerify);

        head = LinkedListRemoveNthFromEnd.removeNthFromEnd(head, 1);
        Assertions.assertNull(head);
    }

    private <T> void verify(Node<T> head, List<T> listToVerify) {
        for (T val : listToVerify) {
            Assertions.assertEquals(val, head.val);
            head = head.next;
        }
    }

}