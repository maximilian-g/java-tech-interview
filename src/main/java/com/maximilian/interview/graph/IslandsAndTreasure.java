package com.maximilian.interview.graph;

import com.maximilian.interview.graph.data.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://neetcode.io/problems/islands-and-treasure">
 * Link to a task</a>
 * <p>
 * You are given a m × n
 * m×n 2D grid initialized with these three possible values:
 * <p>
 * -1 - A water cell that can not be traversed.
 * 0 - A treasure chest.
 * INF - A land cell that can be traversed. We use the integer
 * 2^31 - 1 = 2147483647 to represent INF.
 * Fill each land cell with the distance to its nearest treasure chest.
 * If a land cell cannot reach a treasure chest than the value should remain INF.
 * <p>
 * Assume the grid can only be traversed up, down, left, or right.
 */
public class IslandsAndTreasure {

    public static void islandsAndTreasure(int[][] grid) {
        List<Pair> treasureChests = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    treasureChests.add(new Pair().setI(i).setJ(j));
                }
            }
        }
        bfs(grid, treasureChests);
    }

    private static void bfs(int[][] grid, List<Pair> treasureChests) {
        // any number > 0 is considered as land
        boolean[][] visited = new boolean[grid.length][];
        for (int k = 0; k < visited.length; k++) {
            visited[k] = new boolean[grid[k].length];
        }
        List<Pair> tempList = new ArrayList<>();
        int path = 0;
        while (!treasureChests.isEmpty()) {

            for (Pair pair : treasureChests) {
                tempList.addAll(bfs(grid, visited, pair.i, pair.j, path));
            }

            treasureChests = tempList;
            tempList = new ArrayList<>();
            path++;
        }
    }

    private static List<Pair> bfs(int[][] grid, boolean[][] visited,
                                  int i, int j, int path) {
        if ((i < 0 || i >= grid.length) ||
                (j >= grid[i].length || j < 0) ||
                visited[i][j]) {
            return Collections.emptyList();
        }
        visited[i][j] = true;
        if (grid[i][j] < 0) {
            return Collections.emptyList();
        }

        grid[i][j] = Math.min(grid[i][j], path);
        List<Pair> result = new ArrayList<>();
        result.add(new Pair().setI(i + 1).setJ(j));
        result.add(new Pair().setI(i).setJ(j + 1));
        result.add(new Pair().setI(i - 1).setJ(j));
        result.add(new Pair().setI(i).setJ(j - 1));
        return result;
    }

}
