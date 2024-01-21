package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KClosestPointsToOriginTest {

    @Test
    void kClosest() {

        int[][] expected = new int[][]{
                {-2, 2}
        };
        int[][] result = KClosestPointsToOrigin.kClosest(new int[][]{
                {1, 3},
                {-2, 2}
        }, 1);
        Assertions.assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }


    }

}