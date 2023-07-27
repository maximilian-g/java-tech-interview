package com.maximilian.interview.common.backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // first character does not match with current from board, skipping
                if (word.charAt(0) != board[i][j]) {
                    continue;
                }
                if (backtrack(board, word, new StringBuilder(),
                        i, j, 0, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, StringBuilder foundWordBuilder,
                                     int startI, int startJ, int wordIndex, Set<String> positionsUsed) {
        String currentPosition = startI + "," + startJ;
        if (startI < 0 || startJ < 0 ||
                startI >= board.length || startJ >= board[0].length ||
                word.length() < foundWordBuilder.length() ||
                !word.contains(foundWordBuilder) ||
                positionsUsed.contains(currentPosition)) {
            return false;
        }
        foundWordBuilder.append(board[startI][startJ]);

        if (foundWordBuilder.toString().equals(word)) {
            return true;
        }

        positionsUsed.add(currentPosition);
        if (backtrack(board, word, foundWordBuilder, startI, startJ + 1, wordIndex + 1, positionsUsed) ||
                backtrack(board, word, foundWordBuilder, startI, startJ - 1, wordIndex + 1, positionsUsed) ||
                backtrack(board, word, foundWordBuilder, startI + 1, startJ, wordIndex + 1, positionsUsed) ||
                backtrack(board, word, foundWordBuilder, startI - 1, startJ, wordIndex + 1, positionsUsed)) {
            return true;
        }
        positionsUsed.remove(currentPosition);
        foundWordBuilder.deleteCharAt(foundWordBuilder.length() - 1);
        return false;
    }

}
