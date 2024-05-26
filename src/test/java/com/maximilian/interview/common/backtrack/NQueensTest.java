package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class NQueensTest {

    @Test
    void solveNQueens() {

        int n = 4;
        List<List<String>> expected = List.of(
                List.of(".Q..", "...Q", "Q...", "..Q."),
                List.of("..Q.", "Q...", "...Q", ".Q..")
        );
        List<List<String>> result = NQueens.solveNQueens(n);
        Assertions.assertEquals(expected.size(), result.size());
        Assertions.assertIterableEquals(expected, result);

    }

    @Test
    void totalNQueens() {

        int n = 4;
        int expected = 2;
        Assertions.assertEquals(expected, NQueens.totalNQueens(n));
        n = 1;
        expected = 1;
        Assertions.assertEquals(expected, NQueens.totalNQueens(n));

    }

}