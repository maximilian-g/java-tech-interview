package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PunishmentNumberOfIntegerTest {

    @Test
    void punishmentNumber() {
        Assertions.assertEquals(182, PunishmentNumberOfInteger.punishmentNumber(10));
        Assertions.assertEquals(1478, PunishmentNumberOfInteger.punishmentNumber(37));
    }

}