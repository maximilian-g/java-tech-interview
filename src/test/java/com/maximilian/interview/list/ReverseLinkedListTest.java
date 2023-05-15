package com.maximilian.interview.list;

import com.maximilian.interview.list.ReverseLinkedList;
import com.maximilian.interview.stack.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReverseLinkedListTest {

    @Test
    void reverseList() {
        Node<Integer> test = new Node<>(1, new Node<>(2, new Node<>(3)));

        Node<Integer> result = ReverseLinkedList.reverseList(test);
        List<Integer> resultsExpected = List.of(3, 2, 1);

        for (int resultExpected : resultsExpected) {
            Assertions.assertEquals(resultExpected, result.val);
            result = result.next;
        }
    }

}