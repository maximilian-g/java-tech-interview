package com.maximilian.interview.common.dp;

/**
 * You are given an integer array cost where cost[i]
 * is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * Constraints:
 * <p>
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class MinCostClimbingStairs {

    // bottom up solution
    public static int minCostClimbingStairsBottomUp(int[] cost) {
        int one = 0;
        int two = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            cost[i] += Math.min(one, two);
            two = one;
            one = cost[i];
        }

        return Math.min(cost[0], cost[1]);
    }

    // bottom down solution
    public static int minCostClimbingStairsBottomDown(int[] cost) {
        int one = 0;
        int two = 0;

        for (int i = 0; i < cost.length; i++) {
            cost[i] += Math.min(one, two);
            two = one;
            one = cost[i];
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    // without memoizing
    public static int minCostClimbingStairsRecursive(int[] cost) {
        return Math.min(minCostClimbingStairsRecursive(cost, 0),
                minCostClimbingStairsRecursive(cost, 1));
    }

    private static int minCostClimbingStairsRecursive(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }
        return Math.min(cost[index] + minCostClimbingStairsRecursive(cost, index + 1),
                cost[index] + minCostClimbingStairsRecursive(cost, index + 2));
    }

}
