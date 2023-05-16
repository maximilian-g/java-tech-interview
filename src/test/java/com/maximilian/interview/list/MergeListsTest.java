package com.maximilian.interview.list;

import com.maximilian.interview.stack.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeListsTest {

    @Test
    void testMerge() {
        Node<Integer> l1 = new Node<>(1, new Node<>(4, new Node<>(5)));
        Node<Integer> l2 = new Node<>(1, new Node<>(3, new Node<>(4)));
        Node<Integer> l3 = new Node<>(2, new Node<>(6));

        Node<Integer>[] arr = new Node[]{
                l1, l2, l3
        };

        Node<Integer> expectedResult = makeNodeFrom(new Integer[]{1, 1, 2, 3, 4, 4, 5, 6});

        Node<Integer> head = MergeLists.mergeKLists(arr);
        while (head != null) {
            Assertions.assertEquals(expectedResult.val, head.val);
            head = head.next;
            expectedResult = expectedResult.next;
        }

        Assertions.assertNull(MergeLists.mergeKLists(new Node[0]));

    }

    private <T> Node<T> makeNodeFrom(T[] arr) {
        Node<T> head = null;
        Node<T> temp = null;
        for (T val : arr) {
            if (head == null) {
                head = new Node<>(val);
                temp = head;
            } else {
                temp.next = new Node<>(val);
                temp = temp.next;
            }
        }
        return head;
    }

}