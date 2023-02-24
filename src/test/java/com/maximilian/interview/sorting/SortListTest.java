package com.maximilian.interview.sorting;

import com.maximilian.interview.stack.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class SortListTest {

    @Test
    void sortList() {
        Assertions.assertNull(SortList.sortList(null));

        List<Integer> initialValues = new ArrayList<>();
        Node<Integer> head = null;
        Node<Integer> currentNode = null;

        for (int i = 10; i >= 0; i--) {
            initialValues.add(i);
            if (head == null) {
                head = new Node<>(i);
                currentNode = head;
            } else {
                Node<Integer> newNode = new Node<>(i);
                currentNode.next = newNode;
                currentNode = newNode;
            }
        }

        Node<Integer> res = SortList.sortList(head);

        initialValues.sort(Comparator.naturalOrder());
        for (int val : initialValues) {
            Assertions.assertEquals(val, res.val);
            // should not throw npe, size must be eq to initialValues.size()
            res = res.next;
        }
    }

}