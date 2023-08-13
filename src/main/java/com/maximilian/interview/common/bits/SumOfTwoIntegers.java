package com.maximilian.interview.common.bits;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */
public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }

}
