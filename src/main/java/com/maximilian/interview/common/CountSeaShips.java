package com.maximilian.interview.common;

import java.util.Objects;

/**
 * There is NxN grid, content of which is 0 and 1, 1 - is a ship(or part of ship)
 * Grid size can be any length, but grid it is always NxN grid.
 * There can be any number of ships.
 * Ship size - from 1x1 to 1xN.
 * Ships are not connected with each other.
 * <p>
 * For example in 3x3 grid - grid[0][0] - grid[0][2] is a 1x3 ship.
 * But other ship already cannot be on grid[1][x], because ships should not connect.
 * From this requirement and given data, other ship(s) can be located only in grid[2][x]
 */
public class CountSeaShips {

    public static int countSeaShips(int[][] grid) {
        Objects.requireNonNull(grid, "Input grid cannot be null");
        // grid validation can be performed here

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1 && isNewShip(grid, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    private static boolean isNewShip(int[][] grid, int i, int j) {
        // up + left check
        return !((i > 0 && grid[i - 1][j] == 1) ||
                 (j > 0 && grid[i][j - 1] == 1));
    }

}
