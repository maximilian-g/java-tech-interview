package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordDictionaryTest {

    @Test
    void wordDictionaryTest() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("president");
        dictionary.addWord("press");
        dictionary.addWord("prevail");

        Assertions.assertTrue(dictionary.search("press"));
        Assertions.assertTrue(dictionary.search("....s"));
        Assertions.assertFalse(dictionary.search("p"));
        Assertions.assertFalse(dictionary.search("presidento"));
        Assertions.assertFalse(dictionary.search("president."));
        Assertions.assertFalse(dictionary.search("presiden"));
        Assertions.assertFalse(dictionary.search(".........."));
        Assertions.assertFalse(dictionary.search("abc"));
    }

}