package com.maximilian.interview.array;

import java.util.Arrays;
import java.util.Objects;

/**
 * Write method that takes array and returns max product of 3 numbers taken from this array
 */
public class MaxMultiplicationOfThree {

    public static int getMaxMultiplicationOfThree(int[] array) {
        Objects.requireNonNull(array, "Input cannot be null");
        if (array.length < 3) {
            throw new IllegalArgumentException("Array must contain at least 3 elements");
        }
        Arrays.sort(array);
        return array[array.length - 1] * array[array.length - 2] * array[array.length - 3];
    }

}
