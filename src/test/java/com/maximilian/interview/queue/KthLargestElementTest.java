package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KthLargestElementTest {

    @Test
    void add() {

        KthLargestElement test = new KthLargestElement(3, new int[]{4, 5, 8, 2});
        Assertions.assertEquals(4, test.add(3));
        Assertions.assertEquals(5, test.add(5));
        Assertions.assertEquals(5, test.add(10));
        Assertions.assertEquals(8, test.add(9));
        Assertions.assertEquals(8, test.add(4));

    }

}