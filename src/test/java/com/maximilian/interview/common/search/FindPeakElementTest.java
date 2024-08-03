package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindPeakElementTest {

    @Test
    void findPeakElement() {

        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        int expected = 5;
        Assertions.assertEquals(expected, FindPeakElement.findPeakElement(arr));

        arr = new int[]{1};
        expected = 0;
        Assertions.assertEquals(expected, FindPeakElement.findPeakElement(arr));

        arr = new int[]{1, 2};
        expected = 1;
        Assertions.assertEquals(expected, FindPeakElement.findPeakElement(arr));

        arr = new int[]{Integer.MIN_VALUE};
        expected = 0;
        Assertions.assertEquals(expected, FindPeakElement.findPeakElement(arr));

    }

}