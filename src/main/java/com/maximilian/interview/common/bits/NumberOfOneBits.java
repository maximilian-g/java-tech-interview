package com.maximilian.interview.common.bits;

/**
 * Write a function that takes the binary representation of an
 * unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, the input will be given as a signed integer type.
 * It should not affect your implementation, as the integer's internal
 * binary representation is the same, whether it is signed or unsigned.
 * <p>
 * In Java, the compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 3, the input represents the signed integer. -3.
 */
public class NumberOfOneBits {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1) {
                res++;
            }
        }
        return res;
    }

}
