package com.maximilian.interview.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertIntervalTest {

    @Test
    void fullyInsert() {

        int[][] initialData = new int[][]{
                {1, 3},
                {4, 10},
                {11, 15}
        };
        int[] inputInterval = new int[]{5, 7};
        int[][] expected = new int[][]{
                {1, 3},
                {4, 10},
                {11, 15}
        };

        // 1 case fully intersect
        int[][] result = InsertInterval.insert(
                initialData,
                inputInterval
        );
        Assertions.assertEquals(result.length, expected.length);
        for (int i = 0; i < initialData.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }

    }

    @Test
    void noneInsert() {

        int[][] initialData = new int[][]{
                {1, 3},
                {4, 10},
                {11, 15}
        };
        int[] inputInterval = new int[]{20, 25};
        int[][] expected = new int[][]{
                {1, 3},
                {4, 10},
                {11, 15},
                {20, 25}
        };

        // 4 case none intersect
        int[][] result = InsertInterval.insert(
                initialData,
                inputInterval
        );
        Assertions.assertEquals(result.length, expected.length);
        for (int i = 0; i < initialData.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }

    }

    @Test
    void rightInsert() {

        int[][] initialData = new int[][]{
                {1, 3},
                {4, 7},
                {12, 15}
        };
        int[] inputInterval = new int[]{10, 13};
        int[][] expected = new int[][]{
                {1, 3},
                {4, 7},
                {10, 15}
        };

        // 3 case right intersect
        int[][] result = InsertInterval.insert(
                initialData,
                inputInterval
        );
        Assertions.assertEquals(result.length, expected.length);
        for (int i = 0; i < initialData.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }

    }

    @Test
    void leftInsert() {

        int[][] initialData = new int[][]{
                {1, 3},
                {4, 7},
                {12, 15}
        };
        int[] inputInterval = new int[]{5, 13};
        int[][] expected = new int[][]{
                {1, 3},
                {4, 15}
        };

        // 2 case left intersect
        int[][] result = InsertInterval.insert(
                initialData,
                inputInterval
        );
        Assertions.assertEquals(result.length, expected.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }

        initialData = new int[][]{
                {1, 3},
                {4, 7},
                {12, 15}
        };
        inputInterval = new int[]{13, 21};
        expected = new int[][]{
                {1, 3},
                {4, 7},
                {12, 21}
        };

        // 2 case left intersect but last interval
        result = InsertInterval.insert(
                initialData,
                inputInterval
        );
        Assertions.assertEquals(result.length, expected.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }

    }

    @Test
    void leftInsertComplex() {

        int[][] initialData = new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] inputInterval = new int[]{4, 8};
        int[][] expected = new int[][]{
                {1, 2},
                {3, 10},
                {12, 16}
        };

        // 2 case left intersect
        int[][] result = InsertInterval.insert(
                initialData,
                inputInterval
        );
        Assertions.assertEquals(result.length, expected.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }

    }

    @Test
    void exceptionalInsert() {

        int[][] initialData = new int[][]{

        };
        int[] inputInterval = new int[]{5, 13};
        int[][] expected = new int[][]{
                {5, 13}
        };

        // case with 0 initial intervals
        int[][] result = InsertInterval.insert(
                initialData,
                inputInterval
        );
        Assertions.assertEquals(result.length, expected.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }

    }

    @Test
    void exceptionalInsertOverwrite() {

        int[][] initialData = new int[][]{
                {1, 5}
        };
        int[] inputInterval = new int[]{0, 6};
        int[][] expected = new int[][]{
                {0, 6}
        };

        int[][] result = InsertInterval.insert(
                initialData,
                inputInterval
        );
        Assertions.assertEquals(result.length, expected.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], result[i]);
        }

    }


}