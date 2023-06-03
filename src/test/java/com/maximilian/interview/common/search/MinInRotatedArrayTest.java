package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinInRotatedArrayTest {

    @Test
    void findMin() {

        int[] arr = new int[]{3, 4, 5, 1, 2};
        Assertions.assertEquals(1, MinInRotatedArray.findMin(arr));

        arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        Assertions.assertEquals(0, MinInRotatedArray.findMin(arr));

        arr = new int[]{3, 4, 5, 1, 2};
        Assertions.assertEquals(1, MinInRotatedArray.findMin(arr));

    }
}