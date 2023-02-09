package com.maximilian.interview.common.search;


import java.util.Objects;

/**
 * Implement a binary search for sorted array of integers, return index of searched element, or -1 if not found
 */
public class BinarySearch {

    public static int binarySearch(int[] sortedArray, int valueToSearch) {
        Objects.requireNonNull(sortedArray, "Input array cannot be null");
        int leftIndex = 0;
        int rightIndex = sortedArray.length - 1;
        while (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (sortedArray[mid] == valueToSearch) {
                return mid;
            }
            if (sortedArray[mid] > valueToSearch) {
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
        }
        return -1;
    }

}
