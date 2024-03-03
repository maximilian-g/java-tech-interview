package com.maximilian.interview.common.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * A valid IP address consists of exactly four integers separated by single dots.
 * Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 * <p>
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses,
 * but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses
 * that can be formed by inserting dots into s. You are not allowed to reorder or
 * remove any digits in s. You may return the valid IP addresses in any order.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 20
 * s consists of digits only.
 */
public class RestoreIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(result, s, new StringBuilder(), 0);
        return result;
    }

    private static void backtrack(List<String> result, String str,
                                  StringBuilder tempResult, int start) {

        String tempResultStr = tempResult.toString();
        boolean isCorrectIp = tempResultStr.matches("\\d+\\.\\d+\\.\\d+\\.\\d+");
        if (str.length() == start) {
            if (isCorrectIp) {
                result.add(tempResultStr);
            }
            return;
        }
        // str is not empty, not all values are used, but we already have some ip
        if (isCorrectIp) {
            return;
        }

        List<String> possibleCombinations = getPossibleByteCombinations(str, start);

        for (String possibleCombination : possibleCombinations) {
            if (!tempResult.isEmpty()) {
                tempResult.append(".");
            }
            tempResult.append(possibleCombination);
            backtrack(result, str, tempResult, possibleCombination.length() + start);
            tempResult.delete(tempResult.length() -
                    possibleCombination.length(), tempResult.length());
            if (!tempResult.isEmpty() && tempResult.charAt(tempResult.length() - 1) == '.') {
                tempResult.delete(tempResult.length() - 1, tempResult.length());
            }
        }

    }

    private static List<String> getPossibleByteCombinations(String str, int start) {
        List<String> possibleCombinations = new ArrayList<>();
        StringBuilder tempResultInner = new StringBuilder();
        for (int i = start; i < str.length(); i++) {
            tempResultInner.append(str.charAt(i));
            String ipByte = tempResultInner.toString();
            if (Integer.parseInt(ipByte) <= 255) {
                possibleCombinations.add(ipByte);
            } else {
                break;
            }
            // no leading zeros allowed
            if (str.charAt(i) == '0' && tempResultInner.length() == 1) {
                break;
            }
        }
        return possibleCombinations;
    }

}
