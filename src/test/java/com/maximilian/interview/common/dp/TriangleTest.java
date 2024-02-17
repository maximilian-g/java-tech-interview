package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TriangleTest {

    @Test
    void minimumTotal() {

        List<List<Integer>> input = Arrays.asList(
                List.of(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        int expected = 11;
        Assertions.assertEquals(expected, Triangle.minimumTotal(input));

        input = List.of(
                List.of(-10)
        );
        expected = -10;
        Assertions.assertEquals(expected, Triangle.minimumTotal(input));

    }

}