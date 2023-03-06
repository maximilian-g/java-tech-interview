package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TopKFrequentElementsTest {

    @Test
    void topKFrequent() {

        Assertions.assertArrayEquals(new int[]{1, 2}, TopKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, TopKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 3));
        Assertions.assertArrayEquals(new int[]{1}, TopKFrequentElements.topKFrequent(new int[]{1}, 1));

    }

}