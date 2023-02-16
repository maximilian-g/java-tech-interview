package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedSquaresTest {

    @Test
    void sortedSquares() {
        Assertions.assertArrayEquals(new int[] {}, SortedSquares.sortedSquares(new int[] {}));
        Assertions.assertArrayEquals(new int[] {1}, SortedSquares.sortedSquares(new int[] {-1}));
        Assertions.assertArrayEquals(new int[] {1, 4, 9}, SortedSquares.sortedSquares(new int[] {-3, -1, 2}));
    }

}