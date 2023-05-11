package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CopyRandomListTest {

    @Test
    void copyRandomList() {

        CopyRandomList.RandomNode<Integer> test = new CopyRandomList.RandomNode<>(1
                , new CopyRandomList.RandomNode<>(2,
                new CopyRandomList.RandomNode<>(3,
                        new CopyRandomList.RandomNode<>(4,
                                new CopyRandomList.RandomNode<>(5))))
        );

        test.random = null;
        test.next.random = test;
        test.next.next.random = test.next.next.next;
        test.next.next.next.random = test;
        test.next.next.next.next.random = null;

        CopyRandomList.RandomNode<Integer> res = CopyRandomList.copyRandomList(test);

        Assertions.assertNotNull(res);
        Assertions.assertEquals(1, res.val);
        Assertions.assertEquals(2, res.next.val);
        Assertions.assertEquals(3, res.next.next.val);
        Assertions.assertEquals(4, res.next.next.next.val);
        Assertions.assertEquals(5, res.next.next.next.next.val);

        Assertions.assertNull(res.random);

        Assertions.assertNotSame(test.next.random, res.next.random);
        Assertions.assertEquals(test.next.random.val, res.next.random.val);

        Assertions.assertNotSame(test.next.next.random, res.next.next.random);
        Assertions.assertEquals(test.next.next.random.val, res.next.next.random.val);

        Assertions.assertNotSame(test.next.next.next.random, res.next.next.next.random);
        Assertions.assertEquals(test.next.next.next.random.val, res.next.next.next.random.val);

        Assertions.assertNull(res.next.next.next.next.random);

        Assertions.assertNull(CopyRandomList.copyRandomList(null));

    }

}