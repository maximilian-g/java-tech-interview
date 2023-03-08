package com.maximilian.interview.array;

import java.util.Arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 */
public class TwoSumInSortedArray {

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int searchValue = target - numbers[i];
            int searchedIndex = Arrays.binarySearch(numbers, i + 1, numbers.length, searchValue);
            if (searchedIndex > 0) {
                return new int[]{i + 1, searchedIndex + 1};
            }
        }
        throw new IllegalArgumentException("Could not find solution");
    }

}
