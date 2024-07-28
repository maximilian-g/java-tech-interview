package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SuccessfulPairsOfSpellsAndPotionsTest {

    @Test
    void successfulPairs() {

        long success = 7;
        int[] spells = {5, 1, 3, 5};
        int[] potions = {1, 2, 3, 4, 5};

        int[] expected = {4, 0, 3, 4};

        Assertions.assertArrayEquals(expected,
                SuccessfulPairsOfSpellsAndPotions.successfulPairs(
                        spells,
                        potions,
                        success
                )
        );

        success = 16;
        spells = new int[]{3, 1, 2};
        potions = new int[]{8, 5, 8};

        expected = new int[]{2, 0, 2};

        Assertions.assertArrayEquals(expected,
                SuccessfulPairsOfSpellsAndPotions.successfulPairs(
                        spells,
                        potions,
                        success
                )
        );

    }

}