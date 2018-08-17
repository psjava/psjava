package org.psjava.ds.graph;

import org.psjava.ds.HashSetFactory;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.util.Assertion;

import java.util.Set;

// TODO use GraphV2
@Deprecated
public class MutableGraph<V, E> implements Graph<V, E> {

    public static <V, E> MutableGraph<V, E> create() {
        return new MutableGraph<V, E>();
    }

    private Set<V> vertices = HashSetFactory.INSTANCE.create();
    private MutableMap<V, DynamicArray<E>> edgeMap = GoodMutableMapFactory.getInstance().create();

    public void insertVertex(V v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
            edgeMap.add(v, new DynamicArray<E>());
        }
    }

    public void addEdge(V from, E edge) {
        Assertion.ensure(edgeMap.containsKey(from), "Given vertex is not in the graph");
        edgeMap.get(from).addToLast(edge);
    }

    @Override
    public Set<V> getVertices() {
        return vertices;
    }

    @Override
    public Iterable<E> getEdges(V v) {
        return edgeMap.get(v);
    }

    @Override
    public String toString() {
        return GraphToString.toString(this);
    }

}
