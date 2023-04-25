package com.maximilian.interview.common.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void fibonacciRecursive() {
        int index = 0;
        Assertions.assertEquals(0, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(1, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(1, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(2, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(3, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(5, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(8, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(13, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(21, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(34, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(55, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(89, Fibonacci.fibonacciRecursive(index++));
        Assertions.assertEquals(144, Fibonacci.fibonacciRecursive(index));

        // large number, 8 796 093 022 208 operations in recursive method
        index = 43;
        Assertions.assertEquals(433494437, Fibonacci.fibonacciRecursive(index));
    }

    @Test
    void fibonacciIterative() {
        int index = 0;
        Assertions.assertEquals(0, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(1, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(1, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(2, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(3, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(5, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(8, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(13, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(21, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(34, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(55, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(89, Fibonacci.fibonacciIterative(index++));
        Assertions.assertEquals(144, Fibonacci.fibonacciIterative(index));

        // large number, but only N operations in iterative method
        index = 43;
        Assertions.assertEquals(433494437, Fibonacci.fibonacciIterative(index));
    }

}