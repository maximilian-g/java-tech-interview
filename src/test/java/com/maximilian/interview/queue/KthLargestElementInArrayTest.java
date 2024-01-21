package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KthLargestElementInArrayTest {

    @Test
    void findKthLargest() {
        int[] input = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, KthLargestElementInArray.findKthLargestSort(input, k));
        Assertions.assertEquals(expected, KthLargestElementInArray.findKthLargestQueue(input, k));

        input = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        expected = 4;
        Assertions.assertEquals(expected, KthLargestElementInArray.findKthLargestSort(input, k));
        Assertions.assertEquals(expected, KthLargestElementInArray.findKthLargestQueue(input, k));
    }

}