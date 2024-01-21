package com.maximilian.interview.queue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane
 * and an integer k, return the k closest points to the origin (0, 0).
 */
public class KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pointsQueue = new PriorityQueue<>(getComparatorOfPoints());
        Collections.addAll(pointsQueue, points);
        int[][] result = new int[k][];
        for (int i = 0; i < result.length; i++) {
            result[i] = pointsQueue.poll();
        }
        return result;
    }

    private static Comparator<int[]> getComparatorOfPoints() {
        return (l, r) -> {
            double x1 = l[0];
            double y1 = l[1];

            double x2 = r[0];
            double y2 = r[1];

            return Double.compare(
                    Math.sqrt(Math.pow(x1, 2.0) + Math.pow(y1, 2.0)),
                    Math.sqrt(Math.pow(x2, 2.0) + Math.pow(y2, 2.0))
            );
        };
    }

}
