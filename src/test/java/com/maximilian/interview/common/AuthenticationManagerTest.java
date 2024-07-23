package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AuthenticationManagerTest {

    @Test
    void authenticationManagerTest() {
        AuthenticationManager manager = new AuthenticationManager(10);
        manager.generate("1", 5);
        manager.generate("2", 7);
        Assertions.assertEquals(2, manager.countUnexpiredTokens(7));
        Assertions.assertEquals(2, manager.countUnexpiredTokens(8));
        Assertions.assertEquals(1, manager.countUnexpiredTokens(15));
        manager.renew("2", 15);
        Assertions.assertEquals(1, manager.countUnexpiredTokens(24));
        Assertions.assertEquals(0, manager.countUnexpiredTokens(25));

    }

}