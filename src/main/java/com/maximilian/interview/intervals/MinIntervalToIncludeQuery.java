package com.maximilian.interview.intervals;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * You are given a 2D integer array intervals, where intervals[i] = [lefti, righti]
 * describes the ith interval starting at lefti and ending at righti (inclusive).
 * The size of an interval is defined as the number of integers it contains,
 * or more formally righti - lefti + 1.
 * <p>
 * You are also given an integer array queries. The answer to the jth query is the size
 * of the smallest interval i such that lefti <= queries[j] <= righti.
 * If no such interval exists, the answer is -1.
 * <p>
 * Return an array containing the answers to the queries.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
 * Output: [3,3,1,4]
 * Explanation: The queries are processed as follows:
 * - Query = 2: The interval [2,4] is the smallest interval containing 2. The answer is 4 - 2 + 1 = 3.
 * - Query = 3: The interval [2,4] is the smallest interval containing 3. The answer is 4 - 2 + 1 = 3.
 * - Query = 4: The interval [4,4] is the smallest interval containing 4. The answer is 4 - 4 + 1 = 1.
 * - Query = 5: The interval [3,6] is the smallest interval containing 5. The answer is 6 - 3 + 1 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
 * Output: [2,-1,4,6]
 * Explanation: The queries are processed as follows:
 * - Query = 2: The interval [2,3] is the smallest interval containing 2. The answer is 3 - 2 + 1 = 2.
 * - Query = 19: None of the intervals contain 19. The answer is -1.
 * - Query = 5: The interval [2,5] is the smallest interval containing 5. The answer is 5 - 2 + 1 = 4.
 * - Query = 22: The interval [20,25] is the smallest interval containing 22. The answer is 25 - 20 + 1 = 6.
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 105
 * 1 <= queries.length <= 105
 * intervals[i].length == 2
 * 1 <= lefti <= righti <= 107
 * 1 <= queries[j] <= 107
 */
public class MinIntervalToIncludeQuery {

    // O(n^2) solution
    public static int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int res = Integer.MAX_VALUE;
            for (int[] interval : intervals) {
                if (isInside(queries[i], interval)) {
                    res = Math.min(res, calculateRange(interval));
                }
            }
            if (res == Integer.MAX_VALUE) {
                res = -1;
            }
            result[i] = res;
        }

        return result;
    }

    // O(n*logn + m*logm)
    public static int[] minIntervalAnotherAnother(int[][] intervals, int[] queries) {
        int[] tempQueries = new int[queries.length];
        System.arraycopy(queries, 0, tempQueries, 0, queries.length);

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        Arrays.sort(tempQueries);
        // query -> result
        Map<Integer, Integer> queryToAnswerMap = new HashMap<>();
        PriorityQueue<int[]> intervalPQ = new PriorityQueue<>(Comparator.comparingInt(MinIntervalToIncludeQuery::calculateRange));
        int index = 0;

        for (int query : tempQueries) {
            while (index < intervals.length && query >= intervals[index][0]) {
                intervalPQ.add(intervals[index++]);
            }

            // removing intervals, which does not intersect current query
            while (!intervalPQ.isEmpty() && (intervalPQ.peek()[1] < query)) {
                intervalPQ.remove();
            }

            // now, priority queue must have the consistent & smallest interval
            int answer = intervalPQ.isEmpty() ? -1 : calculateRange(intervalPQ.peek());
            queryToAnswerMap.put(query, answer);

        }

        // could use "tempQueries" instead, but for readability will declare new variable
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = queryToAnswerMap.get(queries[i]);
        }

        return result;
    }

    private static boolean isInside(int value, int[] interval) {
        return value >= interval[0] && value <= interval[1];
    }

    private static int calculateRange(int[] interval) {
        return interval[1] - interval[0] + 1;
    }

}
