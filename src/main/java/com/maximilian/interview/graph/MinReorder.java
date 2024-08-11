package com.maximilian.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description">
 * Link to a task</a>
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there
 * is only one way to travel between two different cities (this network form a tree).
 * Last year, The ministry of transport decided to orient the roads in one direction
 * because they are too narrow.
 * <p>
 * Roads are represented by connections where connections[i] = [ai, bi] represents
 * a road from city ai to city bi.
 * <p>
 * This year, there will be a big event in the capital (city 0), and many people
 * want to travel to this city.
 * <p>
 * Your task consists of reorienting some roads such that each city can visit the
 * city 0. Return the minimum number of edges changed.
 * <p>
 * It's guaranteed that each city can reach city 0 after reorder.
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 5 * 10^4
 * connections.length == n - 1
 * connections[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 */
public class MinReorder {

    public static int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjMap.put(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            adjMap.get(connection[0]).add(connection[1]);
            adjMap.get(connection[1]).add(-connection[0]);
        }
        return dfs(adjMap, new boolean[n], 0);
    }

    private static int dfs(Map<Integer, List<Integer>> adjMap, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (int to : adjMap.get(from)) {
            int toAbsValue = Math.abs(to);
            if (!visited[toAbsValue]) {
                change += dfs(adjMap, visited, toAbsValue) + (to > 0 ? 1 : 0);
            }
        }
        return change;
    }

}
