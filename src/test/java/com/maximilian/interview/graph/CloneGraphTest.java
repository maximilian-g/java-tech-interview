package com.maximilian.interview.graph;

import com.maximilian.interview.graph.data.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

class CloneGraphTest {

    @Test
    void cloneGraph() {

        testCloneGraph(CloneGraph::cloneGraph);
        testCloneGraph(CloneGraph::cloneGraphV2);

    }

    private void testCloneGraph(Function<Node, Node> methodToTest) {
        Node initialGraphNode = new Node(1);

        Node node2 = new Node(2);
        initialGraphNode.neighbors.add(node2);
        node2.neighbors.add(initialGraphNode);

        Node node3 = new Node(3);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);

        Node node4 = new Node(4);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        node4.neighbors.add(initialGraphNode);
        initialGraphNode.neighbors.add(node4);

        Node result = methodToTest.apply(initialGraphNode);

        // modifying initial graph should not affect new one
        initialGraphNode.val += 1000;
        node2.val += 1000;
        node3.val += 1000;
        node4.val += 1000;

        // all values in result must be in expectedValues set
        Set<Integer> expectedValues = Set.of(1, 2, 3, 4);
        Set<Integer> visited = new HashSet<>();
        dfsAssert(result, v -> expectedValues.contains(v.val), visited);
    }

    private void dfsAssert(Node result, Predicate<Node> predicate, Set<Integer> visited) {
        if (visited.contains(result.val)) {
            return;
        }
        Assertions.assertTrue(predicate.test(result));
        visited.add(result.val);
        result.neighbors.forEach(node -> dfsAssert(node, predicate, visited));
    }

}