package com.maximilian.interview.common.bits;

/**
 * Given an integer n, return an array ans of length n + 1 such that
 * for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */
public class CountingBits {

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = NumberOfOneBits.hammingWeight(i);
        }
        return res;
    }

}
