package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseTheStringTest {

    @Test
    void reverse() {

        Assertions.assertEquals("321", ReverseTheString.reverse("123"));
        Assertions.assertEquals("21", ReverseTheString.reverse("12"));
        Assertions.assertEquals("1", ReverseTheString.reverse("1"));
        Assertions.assertEquals("nailimixaM si eman yM iH",
                ReverseTheString.reverse("Hi My name is Maximilian"));
    }

}