package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchInRotatedArrayTest {

    @Test
    void search() {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        Assertions.assertEquals(4, SearchInRotatedArray.search(arr, target));

        target = 5;
        Assertions.assertEquals(1, SearchInRotatedArray.search(arr, target));

        target = 4;
        Assertions.assertEquals(0, SearchInRotatedArray.search(arr, target));

        target = 1;
        Assertions.assertEquals(5, SearchInRotatedArray.search(arr, target));

        target = 3;
        Assertions.assertEquals(-1, SearchInRotatedArray.search(arr, target));

        arr = new int[]{1};
        target = 0;
        Assertions.assertEquals(-1, SearchInRotatedArray.search(arr, target));

        arr = new int[]{0, 1, 2, 4, 5, 6, 7};
        target = 2;
        Assertions.assertEquals(2, SearchInRotatedArray.search(arr, target));

        arr = new int[]{3, 1};
        target = 1;
        Assertions.assertEquals(1, SearchInRotatedArray.search(arr, target));

    }

}