package com.maximilian.interview.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class GroupAnagramsTest {

    @Test
    void groupAnagrams() {
        List<List<String>> lists = GroupAnagrams.groupAnagrams(new String[]{""});
        Assertions.assertEquals(1, lists.size());
        Assertions.assertEquals(1, lists.get(0).size());
        Assertions.assertEquals("", lists.get(0).get(0));

        lists = GroupAnagrams.groupAnagrams(new String[]{"a"});
        Assertions.assertEquals(1, lists.size());
        Assertions.assertEquals(1, lists.get(0).size());
        Assertions.assertEquals("a", lists.get(0).get(0));

        List<List<String>> answer = List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea"));
        lists = GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        Assertions.assertEquals(3, lists.size());

        lists.sort(Comparator.comparingInt(List::size));
        lists.forEach(Collections::sort);
        // every list inside answer is already sorted
        Assertions.assertIterableEquals(answer, lists);

    }

}