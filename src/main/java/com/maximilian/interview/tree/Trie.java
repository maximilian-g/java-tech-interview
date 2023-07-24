package com.maximilian.interview.tree;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string
 * word that has the prefix "prefix", and false otherwise.
 */
public class Trie {

    private final Map<Character, TrieElement> trieElementMap;
    private final Set<String> words;

    public Trie() {
        this.trieElementMap = new HashMap<>();
        this.words = new HashSet<>();
    }

    public void insert(String word) {
        words.add(word);
        char[] chars = word.toCharArray();
        Map<Character, TrieElement> localTrieElementMap = trieElementMap;
        for (char c : chars) {
            if (!localTrieElementMap.containsKey(c)) {
                localTrieElementMap.put(c, new TrieElement());
            }
            localTrieElementMap = localTrieElementMap.get(c).trieElementMap;
        }
    }

    public boolean search(String word) {
        return words.contains(word);
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Map<Character, TrieElement> localTrieElementMap = trieElementMap;
        for (char c : chars) {
            if (!localTrieElementMap.containsKey(c)) {
                return false;
            }
            localTrieElementMap = localTrieElementMap.get(c).trieElementMap;
        }
        return true;
    }

    private static class TrieElement {
        private final Map<Character, TrieElement> trieElementMap;


        private TrieElement() {
            this.trieElementMap = new HashMap<>();
        }

    }

}
