package org.psjava.algo.graph.mst;

import java.util.Comparator;

import org.psjava.algo.graph.NumberOfConnectedComponents;
import org.psjava.algo.sequence.sort.SortingAlgorithm;
import org.psjava.ds.PSCollection;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromIterable;
import org.psjava.ds.graph.AllEdgeInGraph;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.UndirectedWeightedEdge;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.ds.set.DisjointSet;
import org.psjava.ds.set.MakeSetAll;
import org.psjava.goods.GoodDisjointSet;
import org.psjava.util.Assertion;

public class KruscalAlgorithm {

    public static MinimumSpanningTreeAlgorithm getInstance(final SortingAlgorithm sort) {
        return new MinimumSpanningTreeAlgorithm() {
            @Override
            public <W, V, E extends UndirectedWeightedEdge<V, W>> PSCollection<E> calc(Graph<V, E> graph, final AddableNumberSystem<W> ns) {
                Assertion.ensure(NumberOfConnectedComponents.calc(graph) <= 1);

                MutableArray<E> edges = MutableArrayFromIterable.create(AllEdgeInGraph.wrap(graph));

                sort.sort(edges, new Comparator<E>() {
                    @Override
                    public int compare(E e1, E r2) {
                        return ns.compare(e1.weight(), r2.weight());
                    }
                });

                DisjointSet<V> dset = GoodDisjointSet.create();
                MakeSetAll.make(dset, graph.getVertices());

                DynamicArray<E> result = DynamicArray.create();
                for (E e : edges) {
                    if (dset.find(e.v1()) != dset.find(e.v2())) {
                        result.addToLast(e);
                        dset.union(e.v1(), e.v2());
                    }
                }
                return result;
            }
        };
    }

    private KruscalAlgorithm() {
    }
}
