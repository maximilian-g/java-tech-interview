package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EncodeDecodeTinyUrlTest {

    @Test
    void encodeAndDecode() {

        int iterations = 100_000;
        EncodeDecodeTinyUrl codec = new EncodeDecodeTinyUrl();
        for (int i = 0; i < iterations; i++) {
            String fakeUrl = Integer.toString(i);
            String encoded = codec.encode(fakeUrl);
            Assertions.assertEquals(fakeUrl, codec.decode(encoded));
        }

    }

}