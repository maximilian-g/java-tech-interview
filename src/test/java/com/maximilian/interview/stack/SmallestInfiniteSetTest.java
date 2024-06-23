package com.maximilian.interview.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SmallestInfiniteSetTest {

    @Test
    void popSmallestAndAddBack() {

        SmallestInfiniteSet set = new SmallestInfiniteSet();
        Assertions.assertEquals(1, set.popSmallest());
        Assertions.assertEquals(2, set.popSmallest());
        Assertions.assertEquals(3, set.popSmallest());

        set.addBack(1);
        Assertions.assertEquals(1, set.popSmallest());
        Assertions.assertEquals(4, set.popSmallest());

    }

}