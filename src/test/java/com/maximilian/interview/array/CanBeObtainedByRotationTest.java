package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CanBeObtainedByRotationTest {

    @Test
    void findRotation() {

        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] target = new int[][]{
                {1, 1, 1},
                {0, 1, 0},
                {0, 0, 0}
        };
        Assertions.assertTrue(CanBeObtainedByRotation.findRotation(matrix, target));

    }

}