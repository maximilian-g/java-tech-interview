package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotOriginTest {

    @Test
    void judgeCircle() {
        Assertions.assertTrue(RobotOrigin.judgeCircle(""));
        Assertions.assertTrue(RobotOrigin.judgeCircle("UD"));
        Assertions.assertTrue(RobotOrigin.judgeCircle("UDUD"));
        Assertions.assertTrue(RobotOrigin.judgeCircle("RRRULLLD"));

        Assertions.assertFalse(RobotOrigin.judgeCircle("U"));
        Assertions.assertFalse(RobotOrigin.judgeCircle("LL"));
        Assertions.assertFalse(RobotOrigin.judgeCircle("D"));
    }

}