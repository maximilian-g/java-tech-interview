package com.maximilian.interview.common;

/**
 * Determine the greatest common divisor.
 * Based on "Stephens - Essential Algorithms"
 * GCD(a, b) = GCD(b, a % b)
 * GCD(a, 0) = a
 */
public class GreatestCommonDivisor {

    public static int getGcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcdRecursive(b, a % b);
    }

    public static int getGcdIterative(int a, int b) {
        int mod;
        while (b != 0) {
            mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }

}
