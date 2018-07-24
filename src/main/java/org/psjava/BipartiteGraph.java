package org.psjava;

import org.psjava.util.Assertion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BipartiteGraph<V> {

    private Set<V> lefts = new HashSet<>();
    private Set<V> rights = new HashSet<>();
    private List<BipartiteGraphEdge<V>> edges = new ArrayList<>();

    public void addLeft(V v) {
        Assertion.ensure(!rights.contains(v), () -> "already in right side. vertex=" + v);
        lefts.add(v);
    }

    public void addRight(V v) {
        Assertion.ensure(!lefts.contains(v), () -> "already in left size. vertex=" + v);
        rights.add(v);
    }

    public void addEdge(final V left, final V right) {
        assertVertexExist(left, lefts);
        assertVertexExist(right, rights);
        edges.add(new BipartiteGraphEdge<>(left, right));
    }

    private void assertVertexExist(V v, Set<V> set) {
        Assertion.ensure(set.contains(v), () -> "vertex is not in graph. vertex=" + v);
    }

    Collection<V> getLeftVertices() {
        return Collections.unmodifiableCollection(lefts);
    }

    Collection<V> getRightVertices() {
        return Collections.unmodifiableCollection(rights);
    }

    Collection<BipartiteGraphEdge<V>> getEdges() {
        return Collections.unmodifiableCollection(edges);
    }
}
