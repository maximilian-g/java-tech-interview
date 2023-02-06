package com.maximilian.interview.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphTest {

    @Test
    void print() {
        UndirectedGraph test = new UndirectedGraph();
        test.addVertex("Alpha");
        test.addVertex("Beta");
        test.addVertex("Delta");
        test.addVertex("Gamma");
        test.addEdge("Alpha", "Beta");
        test.addEdge("Gamma", "Delta");

        List<String> expectedResultParts = List.of("Alpha --> Beta", "Beta --> Alpha",
                "Gamma --> Delta", "Delta --> Gamma");

        String result = test.getStringRepresentation();
        for(String part : expectedResultParts) {
            if(!result.contains(part)) {
                throw new RuntimeException("result '" + result + "' must contain part '" + part + "'");
            }
        }
    }
}