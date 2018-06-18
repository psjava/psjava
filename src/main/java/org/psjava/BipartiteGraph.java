package org.psjava;

import org.psjava.ds.graph.BipartiteGraphEdge;
import org.psjava.ds.graph.SimpleBipartiteGraphEdge;
import org.psjava.util.AssertStatus;

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

    public void insertLeftVertex(V v) {
        AssertStatus.assertTrue(!rights.contains(v));
        lefts.add(v);
    }

    public void insertRightVertex(V v) {
        AssertStatus.assertTrue(!lefts.contains(v));
        rights.add(v);
    }

    public void addEdge(final V left, final V right) {
        assertVertexExist(left, lefts);
        assertVertexExist(right, rights);
        edges.add(SimpleBipartiteGraphEdge.create(left, right));
    }

    private void assertVertexExist(V v, Set<V> set) {
        AssertStatus.assertTrue(set.contains(v), "vertex is not in graph");
    }

    public Collection<V> getLeftVertices() {
        return Collections.unmodifiableCollection(lefts);
    }

    public Collection<V> getRightVertices() {
        return Collections.unmodifiableCollection(rights);
    }

    public Collection<BipartiteGraphEdge<V>> getEdges() {
        return Collections.unmodifiableCollection(edges);
    }
}