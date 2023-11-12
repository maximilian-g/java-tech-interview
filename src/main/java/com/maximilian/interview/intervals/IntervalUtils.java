package com.maximilian.interview.intervals;

public class IntervalUtils {

    public static boolean fullyIntersects(int[] intervalA, int[] intervalB) {
        return intervalA[0] <= intervalB[0] && intervalA[1] >= intervalB[0] &&
                intervalA[0] <= intervalB[1] && intervalA[1] >= intervalB[1];
    }

    public static boolean intersects(int[] intervalA, int[] intervalB) {
        return (intervalA[0] <= intervalB[0] && intervalA[1] >= intervalB[0] ||
                intervalA[0] <= intervalB[1] && intervalA[1] >= intervalB[1]) ||
                (intervalB[0] <= intervalA[0] && intervalB[1] >= intervalA[0] ||
                        intervalB[0] <= intervalA[1] && intervalB[1] >= intervalA[1]);
    }

}
