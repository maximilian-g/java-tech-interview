package com.maximilian.interview.hashtable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class FirstRepeatedValue {

    public static int findFirstRepeated(int[] array) {
        Objects.requireNonNull(array, "Input array cannot be null");
        if (array.length < 2) {
            return -1;
        }
        Set<Integer> numberSet = new HashSet<>();
        for (int val : array) {
            if (numberSet.contains(val)) {
                return val;
            }
            numberSet.add(val);
        }
        return -1;
    }

}
