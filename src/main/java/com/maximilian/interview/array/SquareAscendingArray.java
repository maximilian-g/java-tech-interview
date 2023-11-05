package com.maximilian.interview.array;

/**
 * We have an array of N length.
 * Array is sorted (ascending).
 * <p>
 * Return the array that contains all squares of initial array, sorted ascending
 */
public class SquareAscendingArray {

    public static int[] getSquareArray(int[] array) {
        // O(n) solution
        int[] result = new int[array.length];
        for (int i = 0, j = array.length - 1, k = array.length - 1; i <= j && k >= 0; k--) {
            int valI = Math.abs(array[i]);
            int valJ = Math.abs(array[j]);
            if (valI > valJ) {
                result[k] = valI * valI;
                i++;
            } else {
                result[k] = valJ * valJ;
                j--;
            }
        }
        return result;
    }

}
