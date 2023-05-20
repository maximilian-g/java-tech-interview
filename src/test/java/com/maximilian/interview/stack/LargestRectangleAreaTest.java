package com.maximilian.interview.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LargestRectangleAreaTest {

    @Test
    void largestRectangleArea() {
        int[] test = new int[]{2, 1, 5, 6, 2, 3};
        Assertions.assertEquals(10, LargestRectangleArea.largestRectangleArea(test));
        Assertions.assertEquals(10, LargestRectangleArea.largestRectangleAreaFast(test));
    }

}