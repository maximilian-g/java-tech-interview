package com.maximilian.interview.common;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a single string.
 * The encoded string is then decoded back to the original list of strings.
 * <p>
 * Please implement encode and decode
 * <p>
 * Constraints:
 * <p>
 * 0 <= strs.length < 100
 * 0 <= strs[i].length < 200
 * strs[i] contains only UTF-8 characters.
 */
public class EncodeAndDecodeStrings {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Base64.Encoder encoder = Base64.getEncoder();
        for (String str : strs) {
            result.append(new String(encoder.encode(str.getBytes(StandardCharsets.UTF_8))))
                    .append(',');
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        Base64.Decoder decoder = Base64.getDecoder();
        for (String strInBase64 : str.split(",")) {
            result.add(new String(decoder.decode(strInBase64)));
        }
        return result;
    }

}
