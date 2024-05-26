package com.maximilian.interview.common.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * solveNQueens method:
 * The n-queens puzzle is the problem of placing n queens on an n x n
 * chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * You may return the answer in any order.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 9
 * <p>
 * totalNQueens method:
 * The n-queens puzzle is the problem of placing n queens on an n x n
 * chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
public class NQueens {

    private static char[][] generateField(int n) {
        char[][] field = new char[n][];
        for (int i = 0; i < n; i++) {
            field[i] = new char[n];
            Arrays.fill(field[i], '.');
        }
        return field;
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] fields = generateField(n);
        List<List<String>> result = new LinkedList<>();
        backtrack(fields, result, n, 0, 0);
        return result;
    }

    public static int totalNQueens(int n) {
        return solveNQueens(n).size();
    }

    private static void backtrack(char[][] fields, List<List<String>> result, int n, int currentQueens, int rowIndex) {
        if (currentQueens == n) {
            List<String> res = new LinkedList<>();
            for (char[] row : fields) {
                res.add(new String(row));
            }
            result.add(res);
            return;
        }

        for (int j = 0; j < fields[rowIndex].length; j++) {
            fields[rowIndex][j] = 'Q';
            if (isValidQueenPosition(fields)) {
                backtrack(fields, result, n, currentQueens + 1, rowIndex + 1);
            }
            fields[rowIndex][j] = '.';
        }
    }

    private static boolean isValidQueenPosition(char[][] fields) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j] == 'Q' && intersects(fields, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean intersects(char[][] fields, int queenPosI, int queenPosJ) {
        // left
        for (int j = queenPosJ - 1; j >= 0; j--) {
            if (fields[queenPosI][j] == 'Q') {
                return true;
            }
        }

        // up left
        for (int j = queenPosJ - 1, i = queenPosI - 1; j >= 0 && i >= 0; j--, i--) {
            if (fields[i][j] == 'Q') {
                return true;
            }
        }

        // up
        for (int i = queenPosI - 1; i >= 0; i--) {
            if (fields[i][queenPosJ] == 'Q') {
                return true;
            }
        }

        // up right
        for (int i = queenPosI - 1, j = queenPosJ + 1; i >= 0 && j < fields.length; i--, j++) {
            if (fields[i][j] == 'Q') {
                return true;
            }
        }

        // right
        for (int j = queenPosJ + 1; j < fields.length; j++) {
            if (fields[queenPosI][j] == 'Q') {
                return true;
            }
        }

        // down right
        for (int i = queenPosI + 1, j = queenPosJ + 1; i < fields.length && j < fields.length; i++, j++) {
            if (fields[i][j] == 'Q') {
                return true;
            }
        }

        // down
        for (int i = queenPosI + 1; i < fields.length; i++) {
            if (fields[i][queenPosJ] == 'Q') {
                return true;
            }
        }

        // down left
        for (int i = queenPosI + 1, j = queenPosJ - 1; i < fields.length && j >= 0; i++, j--) {
            if (fields[i][j] == 'Q') {
                return true;
            }
        }
        return false;
    }

}
