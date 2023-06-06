package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxSlidingWindowTest {

    @Test
    void maxSlidingWindow() {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] res = new int[]{3, 3, 5, 5, 6, 7};
        Assertions.assertArrayEquals(res, MaxSlidingWindow.maxSlidingWindow(arr, k));
        Assertions.assertArrayEquals(res, MaxSlidingWindow.maxSlidingWindowImproved(arr, k));

        Assertions.assertArrayEquals(arr, MaxSlidingWindow.maxSlidingWindow(arr, 1));
        Assertions.assertArrayEquals(arr, MaxSlidingWindow.maxSlidingWindowImproved(arr, 1));

        arr = new int[]{1};
        Assertions.assertArrayEquals(arr, MaxSlidingWindow.maxSlidingWindow(arr, 1));
        Assertions.assertArrayEquals(arr, MaxSlidingWindow.maxSlidingWindowImproved(arr, 1));
    }

}