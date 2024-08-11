package com.maximilian.interview.graph;

/**
 * <a href="https://leetcode.com/problems/island-perimeter/description/">
 * Link to a task</a>
 * You are given row x col grid representing a map where grid[i][j] = 1
 * represents land and grid[i][j] = 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly
 * one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't
 * connected to the water around the island. One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 */
public class IslandPerimeter {

    // graph approach, but could be solved much better without this approach...
    public static int islandPerimeter(int[][] grid) {

        int startI = -1;
        int startJ = -1;
        boolean foundStart = false;
        for (int i = 0; i < grid.length && !foundStart; i++) {
            for (int j = 0; j < grid[i].length && !foundStart; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                    foundStart = true;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = new boolean[grid[i].length];
        }
        return dfs(grid, startI, startJ, visited);
    }

    private static int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int res = 0;
        if (!isValidCell(grid, i, j) || grid[i][j] == 0 || visited[i][j]) {
            return res;
        }
        visited[i][j] = true;
        res += dfs(grid, i + 1, j, visited);
        res += dfs(grid, i - 1, j, visited);
        res += dfs(grid, i, j + 1, visited);
        res += dfs(grid, i, j - 1, visited);
        res += calculatePerimeterForCell(grid, i, j);
        return res;
    }

    private static boolean isValidCell(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }

    private static int calculatePerimeterForCell(int[][] grid, int i, int j) {
        int res = 0;
        if (i + 1 >= grid.length || grid[i + 1][j] == 0) {
            res++;
        }
        if (i - 1 < 0 || grid[i - 1][j] == 0) {
            res++;
        }
        if (j + 1 >= grid[i].length || grid[i][j + 1] == 0) {
            res++;
        }
        if (j - 1 < 0 || grid[i][j - 1] == 0) {
            res++;
        }
        return res;
    }

}
