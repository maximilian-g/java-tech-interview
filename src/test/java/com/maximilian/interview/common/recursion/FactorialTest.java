package com.maximilian.interview.common.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialTest {

    @Test
    void factorialRecursive() {
        Assertions.assertEquals(1, Factorial.factorialRecursive(-1));
        Assertions.assertEquals(1, Factorial.factorialRecursive(0));
        Assertions.assertEquals(1, Factorial.factorialRecursive(1));

        Assertions.assertEquals(2, Factorial.factorialRecursive(2));
        Assertions.assertEquals(6, Factorial.factorialRecursive(3));
        Assertions.assertEquals(40320, Factorial.factorialRecursive(8));
        Assertions.assertEquals(3628800, Factorial.factorialRecursive(10));
    }

    @Test
    void factorialIterative() {
        Assertions.assertEquals(1, Factorial.factorialIterative(-1));
        Assertions.assertEquals(1, Factorial.factorialIterative(0));
        Assertions.assertEquals(1, Factorial.factorialIterative(1));

        Assertions.assertEquals(2, Factorial.factorialIterative(2));
        Assertions.assertEquals(6, Factorial.factorialIterative(3));
        Assertions.assertEquals(40320, Factorial.factorialIterative(8));
        Assertions.assertEquals(3628800, Factorial.factorialIterative(10));
    }

}