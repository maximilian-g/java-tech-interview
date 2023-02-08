package com.maximilian.interview.array;

import java.util.Objects;

/**
 * Find the second-largest element in the array
 */
public class SecondLargestElement {

    public static int getSecondLargestElement(int[] arr) {
        Objects.requireNonNull(arr, "Input array cannot be null");
        int maxPrev = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int val : arr) {
            if (val > max) {
                maxPrev = max;
                max = val;
            }
        }

        return maxPrev;
    }

}
