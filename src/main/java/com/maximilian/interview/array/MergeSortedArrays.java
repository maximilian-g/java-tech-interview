package com.maximilian.interview.array;

import java.util.Objects;

public class MergeSortedArrays {

    public static int[] mergeSorted(int[] left, int[] right) {
        Objects.requireNonNull(left, "Input array cannot be null.");
        Objects.requireNonNull(right, "Input array cannot be null.");
        if(right.length == 0) {
            return left;
        }
        if(left.length == 0) {
            return right;
        }
        int[] result = new int[left.length + right.length];

        for(int i = 0, j = 0, k = 0; i < result.length; i++) {
            if(j < left.length && k < right.length) {
                if (left[j] > right[k]) {
                    result[i] = right[k++];
                } else {
                    result[i] = left[j++];
                }
            } else if(j < left.length) {
                result[i] = left[j++];
            } else {
                result[i] = right[k++];
            }
        }
        return result;
    }

}
