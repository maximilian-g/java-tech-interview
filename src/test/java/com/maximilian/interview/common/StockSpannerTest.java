package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockSpannerTest {

    @Test
    void next() {

        StockSpanner spanner = new StockSpanner();

        Assertions.assertEquals(1, spanner.next(7));
        Assertions.assertEquals(1, spanner.next(2));
        Assertions.assertEquals(1, spanner.next(1));
        Assertions.assertEquals(3, spanner.next(2));
        Assertions.assertEquals(4, spanner.next(2));

    }

}