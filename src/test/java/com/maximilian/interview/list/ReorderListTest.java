package com.maximilian.interview.list;

import com.maximilian.interview.list.ReorderList;
import com.maximilian.interview.stack.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReorderListTest {

    @Test
    void testReorder() {
        // 1 2 3 4 -> 1 4 2 3
        Node<Integer> test = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4))));

        ReorderList.reorderList(test);

        List<Integer> resultsExpected = List.of(1, 4, 2, 3);

        for (int resultExpected : resultsExpected) {
            Assertions.assertEquals(resultExpected, test.val);
            test = test.next;
        }

    }

}