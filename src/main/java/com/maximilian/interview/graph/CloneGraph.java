package com.maximilian.interview.graph;


import com.maximilian.interview.graph.data.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * <p>
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 */
public class CloneGraph {

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
        Map<Integer, Node> newNodesMap = new HashMap<>();
        bfs(node, adjacencyMap, newNodesMap);
        Node initialNode = newNodesMap.get(node.val);

        for (Integer key : newNodesMap.keySet()) {
            Node currentNode = newNodesMap.get(key);
            Set<Integer> neighbours = adjacencyMap.get(key);
            currentNode.neighbors = neighbours.stream()
                    .map(newNodesMap::get)
                    .collect(Collectors.toList());
        }

        return initialNode;
    }

    public static Node cloneGraphV2(Node node) {
        if (node == null) {
            return null;
        }
        return cloneGraph(node, new HashMap<>());
    }

    private static Node cloneGraph(Node node, Map<Integer, Node> nodeByValueMap) {
        if (nodeByValueMap.containsKey(node.val)) {
            return nodeByValueMap.get(node.val);
        }
        Node newNode = new Node(node.val);
        nodeByValueMap.put(node.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor, nodeByValueMap));
        }
        return newNode;
    }

    // fills adjacencyMap, creates new node for each vertex
    private static void bfs(Node node,
                            Map<Integer, Set<Integer>> adjacencyMap,
                            Map<Integer, Node> newNodesMap) {
        if (adjacencyMap.containsKey(node.val)) {
            return;
        }
        adjacencyMap.put(node.val, node.neighbors.stream().map(vertex -> vertex.val)
                .collect(Collectors.toSet()));
        newNodesMap.put(node.val, new Node(node.val));
        node.neighbors.forEach(vertex -> bfs(vertex, adjacencyMap, newNodesMap));
    }

}
