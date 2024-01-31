package com.maximilian.interview.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SummaryRangesTest {

    @Test
    void basicTestCase() {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        int[][] expectedIntervals = new int[][]{
                {1, 1}
        };
        int[][] result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(3);
        result = summaryRanges.getIntervals();
        expectedIntervals = new int[][]{
                {1, 1},
                {3, 3}
        };
        validate(expectedIntervals, result);

        summaryRanges.addNum(7);
        result = summaryRanges.getIntervals();
        expectedIntervals = new int[][]{
                {1, 1},
                {3, 3},
                {7, 7}
        };
        validate(expectedIntervals, result);

        summaryRanges.addNum(2);
        result = summaryRanges.getIntervals();
        expectedIntervals = new int[][]{
                {1, 3},
                {7, 7}
        };
        validate(expectedIntervals, result);

        summaryRanges.addNum(6);
        result = summaryRanges.getIntervals();
        expectedIntervals = new int[][]{
                {1, 3},
                {6, 7}
        };
        validate(expectedIntervals, result);

        summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        summaryRanges.addNum(0);
        result = summaryRanges.getIntervals();
        expectedIntervals = new int[][]{
                {0, 1},
        };
        validate(expectedIntervals, result);

        summaryRanges.addNum(2);
        result = summaryRanges.getIntervals();
        expectedIntervals = new int[][]{
                {0, 2},
        };
        validate(expectedIntervals, result);

        summaryRanges.addNum(4);
        result = summaryRanges.getIntervals();
        expectedIntervals = new int[][]{
                {0, 2},
                {4, 4},
        };
        validate(expectedIntervals, result);


    }

    @Test
    public void complexTestCase() {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(6);
        int[][] expectedIntervals = new int[][]{
                {6, 6}
        };
        int[][] result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(6);
        expectedIntervals = new int[][]{
                {6, 6}
        };
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(0);
        expectedIntervals = new int[][]{
                {0, 0},
                {6, 6}
        };
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(4);
        expectedIntervals = new int[][]{
                {0, 0},
                {4, 4},
                {6, 6}
        };
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(8);
        expectedIntervals = new int[][]{
                {0, 0},
                {4, 4},
                {6, 6},
                {8, 8}
        };
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(7);
        expectedIntervals = new int[][]{
                {0, 0},
                {4, 4},
                {6, 8}
        };
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(9);
        expectedIntervals = new int[][]{
                {0, 0},
                {4, 4},
                {6, 9}
        };
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(6);
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(4);
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(7);
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(5);
        expectedIntervals = new int[][]{
                {0, 0},
                {4, 9}
        };
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

    }

    @Test
    public void easyTestCase() {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        int[][] expectedIntervals = new int[][]{
                {1, 1}
        };
        int[][] result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(9);
        expectedIntervals = new int[][]{
                {1, 1},
                {9, 9}
        };
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);

        summaryRanges.addNum(2);
        expectedIntervals = new int[][]{
                {1, 2},
                {9, 9}
        };
        result = summaryRanges.getIntervals();
        validate(expectedIntervals, result);
    }


    private void validate(int[][] expected, int[][] actual) {
        Assertions.assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i][0], actual[i][0]);
            Assertions.assertEquals(expected[i][1], actual[i][1]);
        }
    }

}