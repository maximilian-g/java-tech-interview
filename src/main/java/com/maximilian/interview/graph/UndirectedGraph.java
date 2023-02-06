package com.maximilian.interview.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UndirectedGraph {

    private final Map<String, Set<String>> adjacencyList = new HashMap<>();

    public void addVertex(String vertexName) {
        if (adjacencyList.containsKey(vertexName)) {
            throw new IllegalArgumentException("Vertex '" + vertexName + "' is already in the graph.");
        }
        adjacencyList.put(vertexName, new HashSet<>());
    }

    public void addEdge(String from, String to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            throw new IllegalArgumentException("One of the vertices are not in the graph. " +
                    "from: '" + from + "', " +
                    "to: '" + to + "'");
        }
        Set<String> edgesFrom = adjacencyList.get(from);
        Set<String> edgesTo = adjacencyList.get(to);
        edgesFrom.add(to);
        edgesTo.add(from);
    }

    public String getStringRepresentation() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Set<String>> vertexInfo : adjacencyList.entrySet()) {
            builder.append(vertexInfo.getKey())
                    .append(" --> ")
                    .append(String.join(", ", vertexInfo.getValue()))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }

}
