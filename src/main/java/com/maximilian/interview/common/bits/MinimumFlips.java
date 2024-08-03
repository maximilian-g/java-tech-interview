package com.maximilian.interview.common.bits;

/**
 * <a href="https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description">
 * Link to a task</a>
 * <p>
 * Given 3 positives numbers a, b and c. Return the minimum flips
 * required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change
 * the bit 0 to 1 in their binary representation.
 * <p>
 * Constraints:
 * <p>
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 */
public class MinimumFlips {

    public static int minFlips(int a, int b, int c) {
        // a | b is what we have while c is what we want.
        // An XOR operation finds all different bits,
        // i.e. (a | b) ^ c sets the bits where flip(s) is needed.
        // Then we count the set bits.
        //Step 2: There is only one case when two flips are needed:
        // a bit is 0 in c but is 1 in both a and b.
        // An AND operation finds all common 1 bits,
        // i.e. a & b & ((a | b) ^ c) sets the common 1 bits
        // in a, b and the must-flip bits found in Step 1.
        return Integer.bitCount(c ^= (a | b)) + Integer.bitCount(a & b & c);
    }

}
