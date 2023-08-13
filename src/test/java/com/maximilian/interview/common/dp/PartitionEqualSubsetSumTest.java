package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartitionEqualSubsetSumTest {

    @Test
    void canPartition() {

        Assertions.assertTrue(PartitionEqualSubsetSum.canPartition(
                new int[]{1, 5, 11, 5}
        ));
        Assertions.assertTrue(PartitionEqualSubsetSum.canPartition(
                new int[]{1, 1}
        ));
        Assertions.assertFalse(PartitionEqualSubsetSum.canPartition(
                new int[]{1, 2, 3, 5}
        ));
        Assertions.assertFalse(PartitionEqualSubsetSum.canPartition(
                new int[]{1}
        ));
        Assertions.assertTrue(PartitionEqualSubsetSum.canPartition(
                new int[]{2, 2, 1, 1}
        ));

    }
}