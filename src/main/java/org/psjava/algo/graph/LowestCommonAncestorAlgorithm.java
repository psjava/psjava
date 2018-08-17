package org.psjava.algo.graph;

import java.util.Comparator;

import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.SingleSourceDFSOld;
import org.psjava.algo.sequence.rmq.RangeMinimumQuerySession;
import org.psjava.algo.sequence.rmq.RangeMinimumQuery;
import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.LastInArray;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.RootedTree;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.util.VisitorStopper;

public class LowestCommonAncestorAlgorithm {

    private MutableMapFactory mapFactory;
    private RangeMinimumQuery rmq;

    public LowestCommonAncestorAlgorithm(RangeMinimumQuery rmq, MutableMapFactory mapFactory) {
        this.rmq = rmq;
        this.mapFactory = mapFactory;
    }

    private static class VertexAndDepth<V> {
        final V vertex;
        final int depth;

        VertexAndDepth(V v, int d) {
            this.vertex = v;
            this.depth = d;
        }
    }

    public <V, E extends DirectedEdge<V>> LowestCommonAncestorQuerySession<V> calc(RootedTree<V, E> tree) {
        final MutableMap<V, Integer> discoverIndex = mapFactory.create();
        final DynamicArray<VertexAndDepth<V>> history = DynamicArray.create(); // stores vertex and depth

        SingleSourceDFSOld.traverse(tree.graph, tree.root, new DFSVisitorBase<V, E>() {
            @Override
            public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
                discoverIndex.add(vertex, history.size());
                history.addToLast(new VertexAndDepth<V>(vertex, depth));
            }

            @Override
            public void onWalkUp(E downedEdge) {
                int lastDepth = LastInArray.getLast(history).depth;
                history.addToLast(new VertexAndDepth<V>(downedEdge.from(), lastDepth - 1));
            }
        });

        final RangeMinimumQuerySession rmqSession = rmq.preprocess(history, new Comparator<VertexAndDepth<V>>() {
            @Override
            public int compare(VertexAndDepth<V> o1, VertexAndDepth<V> o2) {
                return o1.depth - o2.depth;
            }
        });

        return new LowestCommonAncestorQuerySession<V>() {
            @Override
            public V query(V v1, V v2) {
                int i1 = discoverIndex.get(v1);
                int i2 = discoverIndex.get(v2);
                return history.get(rmqSession.getIndex(Math.min(i1, i2), Math.max(i1, i2) + 1)).vertex;
            }
        };
    }
}
