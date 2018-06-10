package org.psjava.algo;

import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathCalcStatus;
import org.psjava.ds.AddToMapWithSameValue;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.heap.Heap;
import org.psjava.ds.heap.HeapFactory;
import org.psjava.ds.heap.HeapNode;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.ds.numbersystrem.InfinitableAddableNumberSystem;

import java.util.Comparator;
import java.util.function.Function;

public class DijkstraAlgorithm {

    public static SingleSourceShortestPathAlgorithm getInstance(final HeapFactory heapFactory, final MutableMapFactory mapFactory) {
        return SingleSourceShortestPathAlgorithmFactory.create(new SingleSourceShortestPathAlgorithmMaterial() {
            @Override
            public <V, W, E extends DirectedEdge<V>> SingleSourceShortestPathCalcStatus<V, W, E> calc(Graph<V, E> graph, V start, Function<E, W> weightFunction, final InfinitableAddableNumberSystem<W> ns) {
                final SingleSourceShortestPathCalcStatus<V, W, E> status = new SingleSourceShortestPathCalcStatus<V, W, E>();

                AddToMapWithSameValue.add(status.distance, graph.getVertices(), ns.getInfinity());
                status.distance.replace(start, ns.getZero());

                Heap<V> heap = heapFactory.create(new Comparator<V>() {
                    @Override
                    public int compare(V v1, V v2) {
                        return ns.compare(status.distance.get(v1), status.distance.get(v2));
                    }
                });

                MutableMap<V, HeapNode<V>> node = mapFactory.create();
                for (V v : graph.getVertices())
                    node.add(v, heap.insert(v));

                while (!heap.isEmpty()) {
                    V current = heap.extractMinimum();
                    for (E edge : graph.getEdges(current)) {
                        boolean relaxed = Relax.relax(status.distance, status.previous, edge, weightFunction, ns);
                        if (relaxed)
                            node.get(edge.to()).decreaseKey(edge.to());
                    }
                }
                return status;
            }
        });
    }

}