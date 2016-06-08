package org.psjava.algo.graph.shortestpath;

import org.psjava.algo.DijkstraAlgorithmV2;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.heap.HeapFactory;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.goods.GoodMutableMapFactory;

@Deprecated
public class DijkstraAlgorithm implements SingleSourceShortestPathAlgorithm {

    // TODO assert negative weight.

    public static DijkstraAlgorithm getInstance(final HeapFactory heapFactory) {
        return new DijkstraAlgorithm(heapFactory);
    }

    private static final MutableMapFactory MF = GoodMutableMapFactory.getInstance(); // TODO get from calc method or constructor..
    private HeapFactory factory;

    private DijkstraAlgorithm(HeapFactory heapFactory) {
        this.factory = heapFactory;
    }

    @Override
    public <V, W, E extends DirectedWeightedEdge<V, W>> SingleSourceShortestPathResult<V, W, E> calc(Graph<V, E> graph, V start, final AddableNumberSystem<W> weightSystem) {
        return DijkstraAlgorithmV2.getInstance(factory, MF).calc(graph, new Function<E, W>() {
            @Override
            public W get(E edge) {
                return edge.weight();
            }
        }, start, weightSystem);
    }

}