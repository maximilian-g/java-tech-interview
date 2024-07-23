package com.maximilian.interview.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://neetcode.io/problems/design-word-search-data-structure">Link to a task</a>
 * Design a data structure that supports adding new words and searching for existing words.
 * <p>
 * Implement the WordDictionary class:
 * <p>
 * void addWord(word) Adds word to the data structure.
 * bool search(word) Returns true if there is any string in the
 * data structure that matches word or false otherwise.
 * word may contain dots '.' where dots can be matched with any letter.
 * <p>
 * Constraints:
 * <p>
 * 1 <= word.length <= 20
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 */
public class WordDictionary {

    private final Map<Character, DictionaryElement> trieElementMap = new HashMap<>();

    public void addWord(String word) {
        Map<Character, DictionaryElement> currentMap = trieElementMap;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char character = charArray[i];
            if (!currentMap.containsKey(character)) {
                currentMap.put(character, new DictionaryElement());
            }
            if (i == charArray.length - 1) {
                currentMap.get(character).isEndOfSomeWord = true;
            }
            currentMap = currentMap.get(character).elementMap;
        }

    }

    public boolean search(String word) {
        return search(word, 0, trieElementMap);
    }

    private boolean search(String word, int start, Map<Character, DictionaryElement> elementMap) {
        // reached end of word, word is found
        if (start >= word.length()) {
            return false;
        }
        char character = word.charAt(start);
        // checking all elements if we have a '.'
        if (character != '.') {
            DictionaryElement dictionaryElement = elementMap.get(character);
            if (dictionaryElement == null) {
                return false;
            }
            if (start == word.length() - 1 && dictionaryElement.isEndOfSomeWord) {
                return true;
            }
            return search(word, start + 1, dictionaryElement.elementMap);
        }
        if (start == word.length() - 1 &&
                elementMap.entrySet().stream().anyMatch((e) -> e.getValue().isEndOfSomeWord)) {
            return true;
        }
        for (Map.Entry<Character, DictionaryElement> entry : elementMap.entrySet()) {
            if (search(word, start + 1, entry.getValue().elementMap)) {
                return true;
            }
        }
        return false;
    }

    private static class DictionaryElement {
        private final Map<Character, DictionaryElement> elementMap = new HashMap<>();
        private boolean isEndOfSomeWord;
    }

}
