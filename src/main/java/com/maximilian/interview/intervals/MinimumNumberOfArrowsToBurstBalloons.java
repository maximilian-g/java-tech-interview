package com.maximilian.interview.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description">Link to a task</a>
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where points[i] = [xstart, xend]
 * denotes a balloon whose horizontal diameter stretches between xstart and xend.
 * You do not know the exact y-coordinates of the balloons.
 * <p>
 * Arrows can be shot up directly vertically (in the positive y-direction) from different
 * points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at
 * x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot.
 * A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * <p>
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * <p>
 * Constraints:
 * <p>
 * 1 <= points.length <= 10^5
 * points[i].length == 2
 * -2^31 <= xstart < xend <= 2^31 - 1
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(v -> v[1]));

        int prevEnd = points[0][1];
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prevEnd) {
                result++;
                prevEnd = points[i][1];
            }
        }
        return result;
    }

}
