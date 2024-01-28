package com.maximilian.interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int elementsInMatrix = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>(elementsInMatrix);
        boolean[][] visited = new boolean[matrix.length][];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = new boolean[matrix[0].length];
        }

        Direction initialDirection = Direction.RIGHT;
        IndexHolder indexHolder = new IndexHolder();

        while (result.size() != elementsInMatrix) {
            if (!visited[indexHolder.i][indexHolder.j]) {
                result.add(matrix[indexHolder.i][indexHolder.j]);
                visited[indexHolder.i][indexHolder.j] = true;
            }
            if (result.size() != elementsInMatrix) {
                initialDirection = initialDirection.performIncrementAndGetNextDirection(indexHolder, matrix, visited);
            }
        }
        return result;
    }

    private static class IndexHolder {
        private int i = 0;
        private int j = 0;
    }

    private enum Direction {
        RIGHT {
            @Override
            Direction performIncrementAndGetNextDirection(IndexHolder indexHolder, int[][] matrix, boolean[][] visited) {
                if (indexHolder.j + 1 < matrix[indexHolder.i].length && !visited[indexHolder.i][indexHolder.j + 1]) {
                    indexHolder.j++;
                    return this;
                }
                //changing direction to down
                return Direction.DOWN.performIncrementAndGetNextDirection(indexHolder, matrix, visited);
            }
        },
        DOWN {
            @Override
            Direction performIncrementAndGetNextDirection(IndexHolder indexHolder, int[][] matrix, boolean[][] visited) {
                if (indexHolder.i + 1 < matrix.length && !visited[indexHolder.i + 1][indexHolder.j]) {
                    indexHolder.i++;
                    return this;
                }
                //changing direction to left
                return Direction.LEFT.performIncrementAndGetNextDirection(indexHolder, matrix, visited);
            }
        },
        LEFT {
            @Override
            Direction performIncrementAndGetNextDirection(IndexHolder indexHolder, int[][] matrix, boolean[][] visited) {
                if (indexHolder.j - 1 >= 0 && !visited[indexHolder.i][indexHolder.j - 1]) {
                    indexHolder.j--;
                    return this;
                }
                //changing direction to up
                return Direction.UP.performIncrementAndGetNextDirection(indexHolder, matrix, visited);
            }
        },
        UP {
            @Override
            Direction performIncrementAndGetNextDirection(IndexHolder indexHolder, int[][] matrix, boolean[][] visited) {
                if (indexHolder.i - 1 >= 0 && !visited[indexHolder.i - 1][indexHolder.j]) {
                    indexHolder.i--;
                    return this;
                }
                //changing direction to up
                return Direction.RIGHT.performIncrementAndGetNextDirection(indexHolder, matrix, visited);
            }
        };

        abstract Direction performIncrementAndGetNextDirection(IndexHolder indexHolder, int[][] matrix, boolean[][] visited);

    }

}
