package com.maximilian.interview.array;

public class RotateArray {

    /**
     * Given an integer array nums,
     * rotate the array to the right by rotateFactor steps,
     * where rotateFactor is non-negative.
     *
     * Solution below has following properties:
     * Time complexity:  O(n)
     */
    public static void rotate(int[] array, int rotateFactor) {
        if(rotateFactor == 0 || array.length < 2) {
            return;
        }
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            res[(i + rotateFactor) % array.length] = array[i];
        }
        System.arraycopy(res, 0, array, 0, array.length);
    }

}
