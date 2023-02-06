package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonItemsInside2ArraysTest {

    @Test
    void areCommonItemsPresent() {
        Assertions.assertThrows(NullPointerException.class, () ->
                CommonItemsInside2Arrays.areCommonItemsPresent(null, null));
        Assertions.assertThrows(NullPointerException.class, () ->
                CommonItemsInside2Arrays.areCommonItemsPresent(List.of(), null));
        Assertions.assertDoesNotThrow(() ->
                CommonItemsInside2Arrays.areCommonItemsPresent(List.of(), List.of()));

        assertFalse(CommonItemsInside2Arrays.areCommonItemsPresent(List.of(), List.of()));
        assertTrue(CommonItemsInside2Arrays.areCommonItemsPresent(List.of("123"), List.of("123")));
        assertTrue(CommonItemsInside2Arrays.areCommonItemsPresent(List.of("123"), List.of("1", "123")));
        assertTrue(CommonItemsInside2Arrays.areCommonItemsPresent(List.of("1", "123"), List.of("123")));

        assertFalse(CommonItemsInside2Arrays.areCommonItemsPresent(List.of("1", "2", "3"), List.of("4", "5", "6")));
    }

}