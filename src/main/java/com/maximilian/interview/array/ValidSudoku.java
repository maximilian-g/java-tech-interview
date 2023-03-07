package com.maximilian.interview.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * TODO old solution, probably code review is needed
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        Set<Integer> checkedColumns = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!checkedColumns.contains(j)) {
                    if (!isColumnValid(board, j)) {
                        return false;
                    }
                    checkedColumns.add(j);
                }
                if (!isRowValid(board[i])) {
                    return false;
                }
                if (i % 3 == 0 && j % 3 == 0 && !isCubeValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isColumnValid(char[][] board, int columnIndex) {
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][columnIndex] != '.') {
                try {
                    int integerValue = getInteger(board[i][columnIndex]);
                    if (integers.contains(integerValue) || integerValue < 1 || integerValue > 9) {
                        return false;
                    }
                    integers.add(integerValue);
                } catch (Exception ex) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isRowValid(char[] row) {
        Set<Integer> integers = new HashSet<>();
        for (char value : row) {
            if (value != '.') {
                try {
                    int integerValue = getInteger(value);
                    if (integers.contains(integerValue) || integerValue < 1 || integerValue > 9) {
                        return false;
                    }
                    integers.add(integerValue);
                } catch (Exception ex) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isCubeValid(char[][] board, int startI, int startJ) {
        Set<Integer> integers = new HashSet<>();
        for (int i = startI; i < startI + 3; i++) {
            for (int j = startJ; j < startJ + 3; j++) {
                if (board[i][j] != '.') {
                    try {
                        int integerValue = getInteger(board[i][j]);
                        if (integers.contains(integerValue) || integerValue < 1 || integerValue > 9) {
                            return false;
                        }
                        integers.add(integerValue);
                    } catch (Exception ex) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int getInteger(char value) {
        return Integer.parseInt(value + "");
    }

}
