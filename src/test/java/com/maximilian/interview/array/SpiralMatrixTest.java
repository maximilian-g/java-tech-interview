package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SpiralMatrixTest {

    @Test
    void spiralOrder() {

        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> expected = List.of(1, 2, 3, 6, 9, 8, 7, 4, 5);
        List<Integer> result = SpiralMatrix.spiralOrder(matrix);

        Assertions.assertEquals(expected.size(), result.size());

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }

    }

}