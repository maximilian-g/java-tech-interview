package com.maximilian.interview.common.bits;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit
 * integer range [-2^31, 2^31 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseInteger {

    public static int reverse(int x) {
        boolean isNegative = x < 0;
        x = Math.abs(x);
        int result = 0;
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < result) {
                return 0;
            }
            result = 10 * result + x % 10;
            x /= 10;
        }
        if (isNegative) {
            result *= -1;
        }
        return result;
    }

}
