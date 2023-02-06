package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArraysTest {

    @Test
    void mergeSorted() {

        assertThrows(NullPointerException.class, () -> MergeSortedArrays.mergeSorted(null, null));
        assertThrows(NullPointerException.class, () -> MergeSortedArrays.mergeSorted(new int[0], null));

        Assertions.assertArrayEquals(new int[] {0, 3, 4, 4, 6, 30, 31},
                MergeSortedArrays.mergeSorted(new int[] {0, 3, 4, 31}, new int[] {4, 6, 30}));

        Assertions.assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6},
                MergeSortedArrays.mergeSorted(new int[] {1, 3, 5}, new int[] {2, 4, 6}));

        Assertions.assertArrayEquals(new int[] {0, 3, 4, 31},
                MergeSortedArrays.mergeSorted(new int[] {0, 3, 4, 31}, new int[0]));

        Assertions.assertArrayEquals(new int[] {0, 3, 4, 31},
                MergeSortedArrays.mergeSorted(new int[0], new int[] {0, 3, 4, 31}));

    }
}