package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RotateImageTest {

    @Test
    void rotate() {

        int[][] input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        RotateImage.rotateInPlace(
                input
        );

        for(int i = 0; i < input.length; i++) {
            Assertions.assertArrayEquals(expected[i], input[i]);
        }

    }

}