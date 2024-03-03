package com.maximilian.interview.common.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RestoreIPAddressesTest {

    @Test
    void restoreIpAddresses() {

        String input = "25525511135";
        List<String> expected = List.of("255.255.11.135", "255.255.111.35");
        List<String> result = RestoreIPAddresses.restoreIpAddresses(input);
        Assertions.assertEquals(expected.size(), result.size());
        for (String ipAddress : expected) {
            Assertions.assertTrue(result.contains(ipAddress));
        }

        input = "0000";
        expected = List.of("0.0.0.0");
        result = RestoreIPAddresses.restoreIpAddresses(input);
        Assertions.assertEquals(expected.size(), result.size());
        for (String ipAddress : expected) {
            Assertions.assertTrue(result.contains(ipAddress));
        }

        input = "101023";
        expected = List.of("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3");
        result = RestoreIPAddresses.restoreIpAddresses(input);
        Assertions.assertEquals(expected.size(), result.size());
        for (String ipAddress : expected) {
            Assertions.assertTrue(result.contains(ipAddress));
        }

    }

}