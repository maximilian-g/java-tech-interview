package com.maximilian.interview.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReversePolishNotationTest {

    @Test
    void evalRPN() {

        Assertions.assertEquals(1, ReversePolishNotation.evalRPN(new String[]{"4", "3", "-"}));
        Assertions.assertEquals(9, ReversePolishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        Assertions.assertEquals(6, ReversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        Assertions.assertEquals(22, ReversePolishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

    }

}