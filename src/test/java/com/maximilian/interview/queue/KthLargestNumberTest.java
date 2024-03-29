package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KthLargestNumberTest {

    @Test
    void kthLargestNumber() {

        String[] input = new String[]{"3", "6", "7", "10"};
        int k = 4;
        String expected = "3";
        Assertions.assertEquals(expected, KthLargestNumber.kthLargestNumber(input, k));

        input = new String[]{"2", "21", "12", "1"};
        k = 3;
        expected = "2";
        Assertions.assertEquals(expected, KthLargestNumber.kthLargestNumber(input, k));

        input = new String[]{"0", "0"};
        k = 2;
        expected = "0";
        Assertions.assertEquals(expected, KthLargestNumber.kthLargestNumber(input, k));

        input = new String[]{"623986800", "3", "887298", "695", "794", "6888794705", "269409", "59930972", "723091307", "726368", "8028385786", "378585"};
        k = 11;
        expected = "695";
        Assertions.assertEquals(expected, KthLargestNumber.kthLargestNumber(input, k));

        input = new String[]{"683339452288515879", "7846081062003424420", "4805719838", "4840666580043", "83598933472122816064", "522940572025909479", "615832818268861533", "65439878015", "499305616484085", "97704358112880133", "23861207501102", "919346676", "60618091901581", "5914766072", "426842450882100996", "914353682223943129", "97", "241413975523149135", "8594929955620533", "55257775478129", "528", "5110809", "7930848872563942788", "758", "4", "38272299275037314530", "9567700", "28449892665", "2846386557790827231", "53222591365177739", "703029", "3280920242869904137", "87236929298425799136", "3103886291279"};
        k = 3;
        expected = "38272299275037314530";
        Assertions.assertEquals(expected, KthLargestNumber.kthLargestNumber(input, k));

    }

}