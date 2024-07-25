package com.maximilian.interview.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/search-suggestions-system/description">Link to a task</a>
 * You are given an array of strings products and a string searchWord.
 * <p>
 * Design a system that suggests at most three product names from products
 * after each character of searchWord is typed. Suggested products should
 * have common prefix with searchWord. If there are more than three products
 * with a common prefix return the three lexicographically minimums products.
 * <p>
 * Return a list of lists of the suggested products after each character of searchWord is typed.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= products.length <= 1000
 * 1 <= products[i].length <= 3000
 * 1 <= sum(products[i].length) <= 2 * 10^4
 * All the strings of products are unique.
 * products[i] consists of lowercase English letters.
 * 1 <= searchWord.length <= 1000
 * searchWord consists of lowercase English letters.
 */
public class SearchSuggestionsSystem {

    // brute force solution O(n^2):
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>(searchWord.length());
        List<String> localResult = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            String subString = searchWord.substring(0, i + 1);
            for (String product : products) {
                if (product.startsWith(subString)) {
                    localResult.add(product);
                }
                if (localResult.size() == 3) {
                    break;
                }
            }
            result.add(localResult);
            localResult = new ArrayList<>();
        }
        return result;
    }

}
