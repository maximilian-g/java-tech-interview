package com.maximilian.interview.graph;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 on the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
public class MaxAreaOfIsland {

    // not production like code,
    // in case of multiple threads getting maxAreaOfIsland result will be unknown
    private static int localResult = 0;

    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] pathGrid = new boolean[grid.length][];
        for (int i = 0; i < pathGrid.length; i++) {
            pathGrid[i] = new boolean[grid[0].length];
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dfs(grid, pathGrid, i, j);
                result = Math.max(localResult, result);
                localResult = 0;
            }
        }
        return result;
    }

    // depth first search in case if current int = 1
    private static void dfs(int[][] grid, boolean[][] pathGrid, int startI, int startJ) {
        if ((startI >= grid.length || startI < 0) ||
                (startJ < 0 || startJ >= grid[0].length) ||
                pathGrid[startI][startJ]) {
            return;
        }
        pathGrid[startI][startJ] = true;
        if (grid[startI][startJ] == 0) {
            return;
        }
        localResult++;

        dfs(grid, pathGrid, startI + 1, startJ);
        dfs(grid, pathGrid, startI, startJ + 1);
        dfs(grid, pathGrid, startI - 1, startJ);
        dfs(grid, pathGrid, startI, startJ - 1);
    }

}
