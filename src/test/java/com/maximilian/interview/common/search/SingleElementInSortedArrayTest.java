package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingleElementInSortedArrayTest {

    @Test
    void singleNonDuplicate() {

        int[] input = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        int expected = 2;
        Assertions.assertEquals(expected, SingleElementInSortedArray.singleNonDuplicate(input));

        input = new int[]{3, 3, 7, 7, 10, 11, 11};
        expected = 10;
        Assertions.assertEquals(expected, SingleElementInSortedArray.singleNonDuplicate(input));

        input = new int[]{1, 1, 2};
        expected = 2;
        Assertions.assertEquals(expected, SingleElementInSortedArray.singleNonDuplicate(input));

        input = new int[]{1, 2, 2};
        expected = 1;
        Assertions.assertEquals(expected, SingleElementInSortedArray.singleNonDuplicate(input));

    }

}