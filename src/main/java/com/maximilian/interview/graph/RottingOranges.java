package com.maximilian.interview.graph;

import com.maximilian.interview.graph.data.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a
 * rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has
 * a fresh orange. If this is impossible, return -1.
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */
public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        List<Pair> rottenOranges = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.add(new Pair().setI(i).setJ(j));
                }
            }
        }

        int res = bfs(grid, rottenOranges);

        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return -1;
                }
            }
        }

        return res;
    }

    private static int bfs(int[][] grid, List<Pair> rottenOranges) {
        // any number > 0 is considered as land
        boolean[][] visited = new boolean[grid.length][];
        for (int k = 0; k < visited.length; k++) {
            visited[k] = new boolean[grid[k].length];
        }
        List<Pair> tempList = new ArrayList<>();
        int elapsed = 0;
        while (!rottenOranges.isEmpty()) {

            for (Pair pair : rottenOranges) {
                visited[pair.i][pair.j] = true;
                tempList.addAll(bfs(grid, visited, pair.i, pair.j));
            }

            rottenOranges = tempList;
            tempList = new ArrayList<>();
            if (!rottenOranges.isEmpty()) {
                elapsed++;
            }
        }
        return elapsed;
    }

    private static List<Pair> bfs(int[][] grid, boolean[][] visited,
                                  int i, int j) {
        if (grid[i][j] == 0) {
            return Collections.emptyList();
        }

        grid[i][j] = 2;
        List<Pair> result = new ArrayList<>();
        addPair(i + 1, j, visited, grid, result);
        addPair(i - 1, j, visited, grid, result);
        addPair(i, j + 1, visited, grid, result);
        addPair(i, j - 1, visited, grid, result);
        return result;
    }

    private static void addPair(int i, int j, boolean[][] visited, int[][] grid, List<Pair> result) {
        if ((i < 0 || i >= visited.length) ||
                (j >= visited[i].length || j < 0)) {
            return;
        }
        if (grid[i][j] == 0 || grid[i][j] == 2) {
            visited[i][j] = true;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        result.add(new Pair().setI(i).setJ(j));
    }

}
