package com.maximilian.interview.common;

import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL is a URL shortening service where you enter a
 * URL such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * Design a class to encode a URL and decode a tiny URL.
 * <p>
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and
 * the tiny URL can be decoded to the original URL.
 * <p>
 * But, lets say that we must generate unique 6-char long encoded string for given url
 * (just as tinyurl does)
 * consisting of [a-zA-Z0-9], having the range of values = 62^6
 * and collision rate = 1/(62^6), increasing with the number of existing encoded strings
 * <p>
 * Implement the Solution class:
 * <p>
 * Solution() Initializes the object of the system.
 * String encode(String longUrl) Returns a tiny URL for the given longUrl.
 * String decode(String shortUrl) Returns the original long URL for the given shortUrl.
 * It is guaranteed that the given shortUrl was encoded by the same object.
 */
public class EncodeDecodeTinyUrl {

    // Implementation is not thread safe

    private final char[] ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    private final Map<String, String> encodedByOriginalUrl = new HashMap<>();
    private final Map<String, String> originalByEncodedUrl = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encodedByOriginalUrl.containsKey(longUrl)) {
            return encodedByOriginalUrl.get(longUrl);
        }
        String code = generateCode();
        while (originalByEncodedUrl.containsKey(code)) {
            code = generateCode();
        }
        originalByEncodedUrl.put(code, longUrl);
        encodedByOriginalUrl.put(longUrl, code);
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return originalByEncodedUrl.get(shortUrl);
    }

    private String generateCode() {
        StringBuilder builder = new StringBuilder();
        // 6 is the target length
        for (int i = 0; i < 6; i++) {
            builder.append(ALPHABET[(int) (Math.random() * (double) ALPHABET.length)]);
        }
        return builder.toString();
    }

}
