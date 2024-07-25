package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GuessNumberHigherLowerTest {

    @Test
    void guessNumber() {

        Assertions.assertEquals(6, new GuessNumberHigherLower(6).guessNumber(10));
        Assertions.assertEquals(1, new GuessNumberHigherLower(1).guessNumber(1));
        Assertions.assertEquals(1, new GuessNumberHigherLower(1).guessNumber(2));
        Assertions.assertEquals(Integer.MAX_VALUE - 1,
                new GuessNumberHigherLower(Integer.MAX_VALUE - 1)
                        .guessNumber(Integer.MAX_VALUE));

    }

}