package com.maximilian.interview.common.dp;

import java.util.Collections;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * <p>
 * For each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row, you may move
 * to either index i or index i + 1 on the next row.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 * <p>
 * Input: triangle = [[-10]]
 * Output: -10
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 <= triangle[i][j] <= 10^4
 */
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevRow = Collections.emptyList();
        for (List<Integer> row : triangle) {
            // first row
            if (row.size() == 1) {
                prevRow = row;
            } else {
                for (int i = 0; i < row.size(); i++) {
                    if (i == 0) {
                        row.set(i, prevRow.get(i) + row.get(i));
                    } else {
                        if (i == prevRow.size()) {
                            row.set(i, prevRow.get(i - 1) + row.get(i));
                        } else {
                            row.set(i, Math.min(prevRow.get(i) + row.get(i), prevRow.get(i - 1) + row.get(i)));
                        }
                    }
                }
                prevRow = row;
            }
        }
        return prevRow.stream().mapToInt(v -> v).min().orElse(0);
    }

}
