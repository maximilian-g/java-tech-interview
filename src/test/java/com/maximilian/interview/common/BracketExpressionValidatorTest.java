package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketExpressionValidatorTest {

    @Test
    void validate() {
        Assertions.assertTrue(BracketExpressionValidator.validate("()"));
        Assertions.assertTrue(BracketExpressionValidator.validate(""));
        Assertions.assertFalse(BracketExpressionValidator.validate(")"));

        Assertions.assertTrue(BracketExpressionValidator.validate("<(([]))>"));
        Assertions.assertTrue(BracketExpressionValidator.validate("<[]>"));
        Assertions.assertTrue(BracketExpressionValidator.validate("([{}])"));
        Assertions.assertFalse(BracketExpressionValidator.validate("([)]"));

        Assertions.assertTrue(BracketExpressionValidator.validate("<>[]<>()"));
        Assertions.assertTrue(BracketExpressionValidator.validate("<[]>"));
    }

}