package com.maximilian.interview.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MaxStreamViewersTest {

    @Test
    void maxViewers() {
        List<TestCase> testCases = getTestCases();

        for (TestCase testCase : testCases) {
            System.out.println("Executing test case '" + testCase.testCaseDescription + "'...");
            Assertions.assertEquals(testCase.expectedResult, MaxStreamViewers.maxViewers(testCase.data));
        }

    }

    private List<TestCase> getTestCases() {
        return List.of(
                new TestCase(new int[][]{},  0, "0 viewers max, 0 intervals"),
                new TestCase(new int[][]{{0, 10}},  1, "1 viewers max, 1 interval"),
                new TestCase(new int[][]{{0, 10}, {15, 30}},  1, "1 viewers max, 1 interval"),
                new TestCase(new int[][]{{0, 10}, {5, 15}},  2, "2 viewers max, 2 intersecting intervals"),
                new TestCase(new int[][]{{0, 10}, {10, 15}},  2, "2 viewers max, 2 intersecting intervals(end time of 1 interval is equal to start time of 2 interval)"),
                new TestCase(new int[][]{{0, 10}, {5, 15}, {7, 10}},  3, "3 viewers max, 3 intersecting intervals"),
                new TestCase(new int[][]{{10, 30}, {20, 40}, {39, 50}, {60, 110}, {80, 90}, {30, 70}, {10, 120}},  4, "4 viewers max, 7 intervals")
        );
    }

    private record TestCase(int[][] data, int expectedResult, String testCaseDescription) {

    }

}