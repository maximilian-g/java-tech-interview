package com.maximilian.interview.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrieTest {

    @Test
    void insert() {
        Trie trie = new Trie();
        trie.insert("Hello");

        Assertions.assertTrue(trie.search("Hello"));
        Assertions.assertFalse(trie.search("Hell"));
        Assertions.assertFalse(trie.search("World"));

        Assertions.assertTrue(trie.startsWith("Hello"));
        Assertions.assertTrue(trie.startsWith("Hell"));
        Assertions.assertTrue(trie.startsWith("Hel"));
        Assertions.assertTrue(trie.startsWith("He"));
        Assertions.assertTrue(trie.startsWith("H"));
        Assertions.assertFalse(trie.startsWith("ello"));
    }

}