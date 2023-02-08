package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxMultiplicationOfThreeTest {

    @Test
    void getMaxMultiplicationOfThree() {

        Assertions.assertEquals(3, MaxMultiplicationOfThree.getMaxMultiplicationOfThree(new int[]{1, 3, 1}));
        Assertions.assertEquals(1, MaxMultiplicationOfThree.getMaxMultiplicationOfThree(new int[]{1, 1, 1}));
        Assertions.assertEquals(-28, MaxMultiplicationOfThree.getMaxMultiplicationOfThree(new int[]{7, 4, -1}));
        Assertions.assertEquals(28, MaxMultiplicationOfThree.getMaxMultiplicationOfThree(new int[]{7, 4, -1, 1}));
        Assertions.assertEquals(2800, MaxMultiplicationOfThree.getMaxMultiplicationOfThree(new int[]{7, 4, -1, 1, 100}));
        Assertions.assertEquals(685300, MaxMultiplicationOfThree.getMaxMultiplicationOfThree(
                new int[]{13, 100, 10, 5, 4, 66, 77, 4, 5, 89, 0, -1, -100}
        ));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> MaxMultiplicationOfThree.getMaxMultiplicationOfThree(new int[]{1, 1}));
        Assertions.assertThrows(NullPointerException.class,
                () -> MaxMultiplicationOfThree.getMaxMultiplicationOfThree(null));

    }

}