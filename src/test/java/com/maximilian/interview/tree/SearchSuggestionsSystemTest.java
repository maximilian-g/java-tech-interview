package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SearchSuggestionsSystemTest {

    @Test
    void suggestedProducts() {

        String[] products = {
                "mobile", "mouse", "moneypot", "monitor", "mousepad"
        };
        String input = "mouse";
        List<List<String>> expected = List.of(
                List.of("mobile", "moneypot", "monitor"),
                List.of("mobile", "moneypot", "monitor"),
                List.of("mouse", "mousepad"),
                List.of("mouse", "mousepad"),
                List.of("mouse", "mousepad")
        );
        List<List<String>> result = SearchSuggestionsSystem.suggestedProducts(products, input);
        Assertions.assertEquals(expected.size(), result.size());

        for (int i = 0; i < expected.size(); i++) {
            List<String> expectedElement = expected.get(i);
            List<String> resElement = result.get(i);
            Assertions.assertEquals(expectedElement.size(), resElement.size());
            for (int j = 0; j < expectedElement.size(); j++) {
                Assertions.assertEquals(expectedElement.get(j), resElement.get(j));
            }
        }
    }

}