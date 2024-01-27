package com.maximilian.interview.graph;

/**
 * Given an m x n 2D binary grid
 * Grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        boolean[][] pathGrid = new boolean[grid.length][];
        for (int i = 0; i < pathGrid.length; i++) {
            pathGrid[i] = new boolean[grid[0].length];
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(grid, pathGrid, i, j)) {
                    res += 1;
                }
            }
        }
        return res;
    }

    // depth first search in case if current char is '1'
    private static boolean dfs(char[][] grid, boolean[][] pathGrid, int startI, int startJ) {
        if ((startI >= grid.length || startI < 0) ||
                (startJ < 0 || startJ >= grid[0].length) ||
                pathGrid[startI][startJ]) {
            return false;
        }
        pathGrid[startI][startJ] = true;
        if (grid[startI][startJ] == '0') {
            return false;
        }

        dfs(grid, pathGrid, startI + 1, startJ);
        dfs(grid, pathGrid, startI, startJ + 1);
        dfs(grid, pathGrid, startI - 1, startJ);
        dfs(grid, pathGrid, startI, startJ - 1);
        return true;
    }

}
