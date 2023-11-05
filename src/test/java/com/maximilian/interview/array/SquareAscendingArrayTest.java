package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SquareAscendingArrayTest {

    @Test
    void getSquareArray() {

        Assertions.assertArrayEquals(new int[]{1, 9, 9},
                SquareAscendingArray.getSquareArray(new int[]{-3, 1, 3}));

        Assertions.assertArrayEquals(new int[]{4, 9, 16},
                SquareAscendingArray.getSquareArray(new int[]{-3, 2, 4}));

        Assertions.assertArrayEquals(new int[]{4, 9, 16, 36, 100},
                SquareAscendingArray.getSquareArray(new int[]{-10, -3, 2, 4, 6}));

        Assertions.assertArrayEquals(new int[]{},
                SquareAscendingArray.getSquareArray(new int[]{}));

        Assertions.assertArrayEquals(new int[]{81},
                SquareAscendingArray.getSquareArray(new int[]{-9}));

    }

}