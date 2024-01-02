package com.maximilian.interview.array;

/**
 * Given two n x n binary matrices mat and target,
 * return true if it is possible to make mat equal to target
 * by rotating mat in 90-degree increments, or false otherwise.
 * <p>
 * Constraints:
 * <p>
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] and target[i][j] are either 0 or 1.
 */
public class CanBeObtainedByRotation {

    public static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean r90 = true, r180 = true, r270 = true, rCurr = true;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int curr = mat[row][col];
                // clockwise
                r90 = r90 && curr == target[col][n - 1 - row];
                r180 = r180 && curr == target[n - 1 - row][n - 1 - col];
                r270 = r270 && curr == target[n - 1 - col][row];
                rCurr = rCurr && curr == target[row][col];
            }
        }
        return r90 || r180 || r270 || rCurr;
    }

}
