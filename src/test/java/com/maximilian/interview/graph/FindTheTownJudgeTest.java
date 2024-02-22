package com.maximilian.interview.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindTheTownJudgeTest {

    @Test
    void findJudge() {

        int[][] trustInput = new int[][]{
                {1, 2}
        };
        int n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, FindTheTownJudge.findJudge(n, trustInput));

        trustInput = new int[][]{
                {1, 3},
                {2, 3}
        };
        n = 3;
        expected = 3;
        Assertions.assertEquals(expected, FindTheTownJudge.findJudge(n, trustInput));

        trustInput = new int[][]{
                {1, 3},
                {2, 3},
                {3, 1}
        };
        expected = -1;
        Assertions.assertEquals(expected, FindTheTownJudge.findJudge(n, trustInput));
    }

}