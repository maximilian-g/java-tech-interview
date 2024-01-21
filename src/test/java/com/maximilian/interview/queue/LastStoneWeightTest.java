package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LastStoneWeightTest {

    @Test
    void lastStoneWeight() {

        Assertions.assertEquals(1, LastStoneWeight.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        Assertions.assertEquals(2, LastStoneWeight.lastStoneWeight(new int[]{1, 3}));

    }

}