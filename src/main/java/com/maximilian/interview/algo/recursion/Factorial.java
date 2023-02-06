package com.maximilian.interview.algo.recursion;

public class Factorial {

    public static long factorialRecursive(long value) {
        if (value <= 1) {
            return 1;
        }
        return value * factorialRecursive(value - 1);
    }

    public static long factorialIterative(long value) {
        long res = 1;
        for (int i = 0; i < value; i++) {
            res *= value - i;
        }
        return res;
    }

}
