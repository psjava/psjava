package org.psjava.algo.graph.mst;

import java.util.Comparator;

import org.psjava.algo.graph.NumberOfConnectedComponents;
import org.psjava.ds.PSCollection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.OppositeInUndirectedEdge;
import org.psjava.ds.graph.UndirectedWeightedEdge;
import org.psjava.ds.heap.Heap;
import org.psjava.ds.heap.HeapFactory;
import org.psjava.ds.heap.HeapNode;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.ds.numbersystrem.InfinitableAddableNumberSystem;
import org.psjava.ds.numbersystrem.InfinitableNumber;
import org.psjava.util.Assertion;

public class PrimAlgorithm {

    public static MinimumSpanningTreeAlgorithm getInstance(final HeapFactory heapFactory, final MutableMapFactory mapFactory) {
        return new MinimumSpanningTreeAlgorithm() {
            @Override
            public <W, V, E extends UndirectedWeightedEdge<V, W>> PSCollection<E> calc(Graph<V, E> graph, AddableNumberSystem<W> weightSystem) {
                Assertion.ensure(NumberOfConnectedComponents.calc(graph) <= 1);
                final InfinitableAddableNumberSystem<W> ns = InfinitableAddableNumberSystem.wrap(weightSystem);

                DynamicArray<E> result = DynamicArray.create();
                if (graph.getVertices().size() == 0)
                    return result;

                V start = graph.getVertices().iterator().next();
                final MutableMap<V, InfinitableNumber<W>> distance = mapFactory.create();
                MutableMap<V, E> previous = mapFactory.create();

                for (V v : graph.getVertices())
                    distance.add(v, ns.getInfinity());
                distance.replace(start, ns.getZero());

                Heap<V> heap = heapFactory.create(new Comparator<V>() {
                    @Override
                    public int compare(V o1, V o2) {
                        return ns.compare(distance.get(o1), distance.get(o2));
                    }
                });

                MutableMap<V, HeapNode<V>> nodes = mapFactory.create();
                for (V v : graph.getVertices())
                    nodes.add(v, heap.insert(v));

                while (!heap.isEmpty()) {
                    V current = heap.extractMinimum();
                    if (previous.containsKey(current))
                        result.addToLast(previous.get(current));
                    for (E edge : graph.getEdges(current)) {
                        V opposite = OppositeInUndirectedEdge.get(edge, current);
                        HeapNode<V> node = nodes.get(opposite);
                        if (node.isInHeap()) {
                            InfinitableNumber<W> weight = InfinitableNumber.getFiniteInstance(edge.weight());
                            InfinitableNumber<W> oldDistance = distance.get(opposite);
                            if (ns.compare(oldDistance, weight) > 0) {
                                distance.replace(opposite, weight);
                                previous.addOrReplace(opposite, edge);
                                node.decreaseKey(opposite);
                            }
                        }
                    }
                }
                return result;
            }
        };
    }

    private PrimAlgorithm() {
    }

}
