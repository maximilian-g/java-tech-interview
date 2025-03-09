package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfAlternatingGroupsTest {

    @Test
    void numberOfAlternatingGroups() {

        int[] input = new int[]{0, 1, 0, 1, 0};
        int k = 3;
        Assertions.assertEquals(3, NumberOfAlternatingGroups.numberOfAlternatingGroups(input, k));
        Assertions.assertEquals(3, NumberOfAlternatingGroups.numberOfAlternatingGroupsBruteForce(input, k));

        input = new int[]{0, 1, 0, 0, 1, 0, 1};
        k = 6;
        Assertions.assertEquals(2, NumberOfAlternatingGroups.numberOfAlternatingGroups(input, k));
        Assertions.assertEquals(2, NumberOfAlternatingGroups.numberOfAlternatingGroupsBruteForce(input, k));

        input = new int[]{1, 1, 0, 1};
        k = 4;
        Assertions.assertEquals(0, NumberOfAlternatingGroups.numberOfAlternatingGroups(input, k));
        Assertions.assertEquals(0, NumberOfAlternatingGroups.numberOfAlternatingGroupsBruteForce(input, k));

    }

}