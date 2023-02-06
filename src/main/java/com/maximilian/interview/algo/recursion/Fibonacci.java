package com.maximilian.interview.algo.recursion;

public class Fibonacci {

    public static long fibonacciRecursive(long index) {
        if (index < 2) {
            return index;
        }
        return fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2);
    }

    public static long fibonacciIterative(long index) {
        if (index < 2) {
            return index;
        }
        int prevFirst = 0;
        int prevSecond = 1;
        int currentFibVal = 0;
        for (int i = 2; i <= index; i++) {
            currentFibVal = prevFirst + prevSecond;
            int tmp = prevSecond;
            prevSecond = currentFibVal;
            prevFirst = tmp;
        }
        return currentFibVal;
    }

}
