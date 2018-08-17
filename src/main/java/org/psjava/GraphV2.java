package org.psjava;

import org.psjava.util.Assertion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphV2<V, E> {

    public Set<V> vertices = new HashSet<>();
    public Map<V, List<E>> edgeMap = new HashMap<>();

    public void addVertex(V v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
            edgeMap.put(v, new ArrayList<>());
        }
    }

    public void addEdge(V from, E edge) {
        Assertion.ensure(edgeMap.containsKey(from), "Given vertex is not in the graph");
        edgeMap.get(from).add(edge);
    }

}

