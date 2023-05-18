package com.maximilian.interview.list;

import com.maximilian.interview.list.util.ListUtils;
import com.maximilian.interview.stack.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseKGroupTest {

    @Test
    void reverseKGroup() {

        Node<Integer> test = ListUtils.makeListFrom(new Integer[]{1, 2, 3, 4, 5});

        Node<Integer> expected = ListUtils.makeListFrom(new Integer[]{2, 1, 4, 3, 5});

        Node<Integer> result = ReverseKGroup.reverseKGroup(test, 2);

        testResult(result, expected);

        test = ListUtils.makeListFrom(new Integer[]{1, 2, 3, 4, 5});

        expected = ListUtils.makeListFrom(new Integer[]{3, 2, 1, 4, 5});

        result = ReverseKGroup.reverseKGroup(test, 3);

        testResult(result, expected);

        test = ListUtils.makeListFrom(new Integer[]{1, 2, 3, 4, 5});

        expected = ListUtils.makeListFrom(new Integer[]{1, 2, 3, 4, 5});

        result = ReverseKGroup.reverseKGroup(test, 1);

        testResult(result, expected);

    }

    private <T> void testResult(Node<T> result, Node<T> expected) {
        while (result != null) {
            Assertions.assertEquals(expected.val, result.val);
            result = result.next;
            expected = expected.next;
        }
    }

}