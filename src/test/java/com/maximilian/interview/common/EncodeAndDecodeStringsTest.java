package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class EncodeAndDecodeStringsTest {

    @Test
    void encodeAndDecode() {
        EncodeAndDecodeStrings codec = new EncodeAndDecodeStrings();
        List<String> input = List.of("1", "2", "3", "4");
        String result = codec.encode(input);
        List<String> resultList = codec.decode(result);
        Assertions.assertEquals(input.size(), resultList.size());
        for (int i = 0; i < input.size(); i++) {
            Assertions.assertEquals(input.get(i), resultList.get(i));
        }

        Assertions.assertTrue(codec.encode(Collections.emptyList()).isEmpty());
        Assertions.assertTrue(codec.decode("").isEmpty());

    }

}