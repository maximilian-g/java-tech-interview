package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordSearchTest {

    @Test
    void exist() {

        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        Assertions.assertTrue(WordSearch.exist(board, "ABCCED"));
        Assertions.assertTrue(WordSearch.exist(board, "ABCE"));
        Assertions.assertTrue(WordSearch.exist(board, "ABC"));
        Assertions.assertTrue(WordSearch.exist(board, "AB"));
        Assertions.assertTrue(WordSearch.exist(board, "A"));
        Assertions.assertTrue(WordSearch.exist(board, "SEE"));
        Assertions.assertFalse(WordSearch.exist(board, "X"));
        Assertions.assertFalse(WordSearch.exist(board, "EEE"));

    }

}