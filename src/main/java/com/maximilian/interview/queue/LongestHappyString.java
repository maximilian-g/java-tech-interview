package com.maximilian.interview.queue;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A string s is called happy if it satisfies the following conditions:
 * <p>
 * s only contains the letters 'a', 'b', and 'c'.
 * s does not contain any of "aaa", "bbb", or "ccc" as a substring.
 * s contains at most a occurrences of the letter 'a'.
 * s contains at most b occurrences of the letter 'b'.
 * s contains at most c occurrences of the letter 'c'.
 * Given three integers a, b, and c, return the longest possible happy string.
 * If there are multiple longest happy strings, return any of them.
 * If there is no such string, return the empty string "".
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * Example 1:
 * <p>
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * <p>
 * Constraints:
 * <p>
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 */
public class LongestHappyString {

    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        Queue<IntegerAndCharPair> queue = new PriorityQueue<>(Comparator.comparing(
                (v -> v.integer),
                Comparator.reverseOrder())
        );
        if (a > 0) {
            queue.add(new IntegerAndCharPair(a, 'a'));
        }
        if (b > 0) {
            queue.add(new IntegerAndCharPair(b, 'b'));
        }
        if (c > 0) {
            queue.add(new IntegerAndCharPair(c, 'c'));
        }

        while (queue.size() >= 2) {
            IntegerAndCharPair firstPair = queue.poll();
            if (firstPair.integer >= 2) {
                result.append(firstPair.character).append(firstPair.character);
                firstPair.integer -= 2;
            } else {
                result.append(firstPair.character);
                firstPair.integer -= 1;
            }

            IntegerAndCharPair secondPair = queue.poll();
            if (secondPair.integer >= 2 && firstPair.integer < secondPair.integer) {
                result.append(secondPair.character).append(secondPair.character);
                secondPair.integer -= 2;
            } else {
                result.append(secondPair.character);
                secondPair.integer -= 1;
            }

            if (firstPair.integer > 0) {
                queue.add(firstPair);
            }
            if (secondPair.integer > 0) {
                queue.add(secondPair);
            }
        }

        if (!queue.isEmpty()) {
            IntegerAndCharPair lastValue = queue.poll();
            if (lastValue.integer >= 2) {
                result.append(lastValue.character).append(lastValue.character);
            } else {
                result.append(lastValue.character);
            }
        }

        return result.toString();
    }

    private static class IntegerAndCharPair {
        private int integer;
        private final char character;

        public IntegerAndCharPair(int integer, char character) {
            this.integer = integer;
            this.character = character;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IntegerAndCharPair that)) return false;
            return integer == that.integer && character == that.character;
        }

        @Override
        public int hashCode() {
            return Objects.hash(integer, character);
        }
    }

}
