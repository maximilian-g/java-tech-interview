package com.maximilian.interview.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BrowserHistoryTest {

    @Test
    void visitBackAndForward() {
        String homepage = "leetcode.com";
        BrowserHistory history = new BrowserHistory(homepage);
        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("youtube.com");

        Assertions.assertEquals("facebook.com", history.back(1));
        Assertions.assertEquals("google.com", history.back(1));
        Assertions.assertEquals("facebook.com", history.forward(1));

        history.visit("linkedin.com");

        Assertions.assertEquals("linkedin.com", history.forward(2));
        Assertions.assertEquals("google.com", history.back(2));
        Assertions.assertEquals(homepage, history.back(7));
    }

}