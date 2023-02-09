package com.maximilian.interview.common.search;

import java.util.Arrays;

/**
 * Given 3 arrays a[], b[], c[] and number N
 * Return any i, j, k indexes, for which a[i] + b[j] + c[k] == N, empty list otherwise
 */
public class SumOfThree {

    public static int[] getIndexesOfNSum(int[] a, int[] b, int[] c, int n) {

        Arrays.sort(c);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int valueToFind = n - a[i] - b[j];
                int valueToFindIndex = BinarySearch.binarySearch(c, valueToFind);
                if (valueToFindIndex != -1) {
                    return new int[]{i, j, valueToFindIndex};
                }
            }
        }

        return new int[]{};
    }


}
