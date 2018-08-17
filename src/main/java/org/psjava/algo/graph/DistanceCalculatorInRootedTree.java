package org.psjava.algo.graph;

import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.SingleSourceDFSOld;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.RootedTree;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.ds.numbersystrem.AddInvert;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.SegmentTree;
import org.psjava.util.VisitorStopper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// TODO this is not used any problem. solve something to prove this.
public class DistanceCalculatorInRootedTree {

    private final LowestCommonAncestorAlgorithm lca;
    private final MutableMapFactory mapFactory;

    public DistanceCalculatorInRootedTree(LowestCommonAncestorAlgorithm lca, MutableMapFactory mapFactory) {
        this.lca = lca;
        this.mapFactory = mapFactory;
    }

    public <V, W, E extends DirectedEdge<V>> DistanceCalculatorInRootedTreeResult<V, W> calc(RootedTree<V, E> tree, final Function<E, W> weight, final AddableNumberSystem<W> ns) {
        final List<W> pathWeights = new ArrayList<>();
        final MutableMap<V, Integer> discoverIndex = mapFactory.create();
        final MutableMap<V, Integer> indexOfWalkingDown = mapFactory.create();
        final MutableMap<V, Integer> indexOfWalkingUp = mapFactory.create();

        SingleSourceDFSOld.traverse(tree.graph, tree.root, new DFSVisitorBase<V, E>() {

            @Override
            public void onDiscovered(V vertex, int depth, VisitorStopper stopper) {
                int index = pathWeights.size();
                discoverIndex.add(vertex, index);
            }

            @Override
            public void onWalkDown(E outEdge) {
                int index = pathWeights.size();
                indexOfWalkingDown.add(outEdge.to(), index);
                pathWeights.add(weight.apply(outEdge));
            }

            @Override
            public void onWalkUp(E edge) {
                int index = pathWeights.size();
                indexOfWalkingUp.add(edge.to(), index);
                pathWeights.add(AddInvert.calc(ns, weight.apply(edge)));
            }
        });

        final SegmentTree<W> segmentTree = new SegmentTree<>(pathWeights, ns::add);
        final LowestCommonAncestorQuerySession<V> lcaSession = lca.calc(tree);

        return new DistanceCalculatorInRootedTreeResult<V, W>() {
            @Override
            public W getDistance(V v1, V v2) {
                V ancestor = lcaSession.query(v1, v2);
                W r = ns.getZero();
                if (!v1.equals(ancestor))
                    r = ns.add(r, segmentTree.query(discoverIndex.get(ancestor), discoverIndex.get(v1)));
                if (!v2.equals(ancestor))
                    r = ns.add(r, segmentTree.query(discoverIndex.get(ancestor), discoverIndex.get(v2)));
                return r;
            }

            @Override
            public void modifyDistance(V v1, V v2, W w) {
                V child = (discoverIndex.get(v1) < discoverIndex.get(v2)) ? v2 : v1;
                segmentTree.update(indexOfWalkingDown.get(child), w);
                segmentTree.update(indexOfWalkingUp.get(child), AddInvert.calc(ns, w));
            }
        };
    }

}