package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SecondLargestElementTest {

    @Test
    void getSecondLargestElement() {

        int[] array = new int[]{3, 6, 7, 2, 10, 15, 10, 0};
        Assertions.assertEquals(10, SecondLargestElement.getSecondLargestElement(array));

        // what to do in case of empty array or array with 1 element?
        Assertions.assertEquals(Integer.MIN_VALUE, SecondLargestElement.getSecondLargestElement(new int[]{}));
        Assertions.assertEquals(Integer.MIN_VALUE, SecondLargestElement.getSecondLargestElement(new int[]{1}));
        Assertions.assertEquals(1, SecondLargestElement.getSecondLargestElement(new int[]{1, 2}));

    }

}