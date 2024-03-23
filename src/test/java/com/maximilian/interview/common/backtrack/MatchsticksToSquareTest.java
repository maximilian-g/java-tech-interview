package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatchsticksToSquareTest {

    @Test
    void makesquare() {

        int[] input = new int[]{1, 1, 2, 2, 2};
        Assertions.assertTrue(MatchsticksToSquare.makesquare(input));

        input = new int[]{3, 3, 3, 3, 4};
        Assertions.assertFalse(MatchsticksToSquare.makesquare(input));

        input = new int[]{3, 3, 3, 3};
        Assertions.assertTrue(MatchsticksToSquare.makesquare(input));

        input = new int[]{3, 3, 3};
        Assertions.assertFalse(MatchsticksToSquare.makesquare(input));

        input = new int[]{1, 1, 2, 2, 6, 6, 6};
        Assertions.assertTrue(MatchsticksToSquare.makesquare(input));

        input = new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        Assertions.assertTrue(MatchsticksToSquare.makesquare(input));

    }

}