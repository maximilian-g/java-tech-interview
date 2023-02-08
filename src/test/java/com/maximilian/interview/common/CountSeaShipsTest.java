package com.maximilian.interview.common;

import com.maximilian.interview.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CountSeaShipsTest {

    @Test
    void countSeaShips() {
        List<TestCase> testCases = getTestCases();

        for (TestCase testCase : testCases) {
            System.out.println("Executing test case '" + testCase.testCaseDescription() + "'...");
            Assertions.assertEquals(testCase.expectedResult(), CountSeaShips.countSeaShips(testCase.data()));
        }

    }

    private List<TestCase> getTestCases() {
        return List.of(
                new TestCase(new int[][]{},  0, "0 ships"),
                new TestCase(new int[][]{{1}},  1, "1 ship"),
                new TestCase(new int[][]{{0}},  0, "0 ships"),
                new TestCase(new int[][]{{0, 1},
                                         {1, 0}},  2, "2 ships"),
                new TestCase(new int[][]{{0, 1, 1},
                                         {1, 0, 0},
                                         {0, 1, 1}},  3, "3 ships"),
                new TestCase(new int[][]{{0, 1, 0, 1},
                                         {1, 0, 0, 0},
                                         {0, 1, 0, 1},
                                         {0, 0, 1, 0}},  6, "6 ships")
        );
    }

}