package com.maximilian.interview.graph;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/description">
 * Link to a task</a>
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected
 * directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and
 * no other cities outside the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1
 * if the ith city and the jth city are directly connected, and
 * isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class NumberOfProvinces {

    public static int findCircleNum(int[][] adjMatrix) {
        int graphsCount = 0;
        boolean[] visited = new boolean[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            if (!visited[i]) {
                graphsCount++;
                dfs(adjMatrix, i, visited);
            }
        }

        return graphsCount;
    }

    private static void dfs(int[][] adjMatrix, int i, boolean[] visited) {
        for (int j = 0; j < adjMatrix[i].length; j++) {
            if (adjMatrix[i][j] == 1 && !visited[j]) {
                visited[i] = visited[j] = true;
                dfs(adjMatrix, j, visited);
            }
        }
    }

}
