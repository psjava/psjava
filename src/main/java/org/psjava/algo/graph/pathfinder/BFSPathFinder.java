package org.psjava.algo.graph.pathfinder;

import org.psjava.algo.graph.bfs.BFS;
import org.psjava.algo.graph.bfs.BFSVisitor;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.util.SingleElementCollection;
import org.psjava.util.VisitorStopper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BFSPathFinder {

    public static PathFinder getInstance() {
        return new PathFinder() {
            @Override
            public <V, E extends DirectedEdge<V>> Collection<E> find(Graph<V, E> adj, V start, final V target, Collection<E> def) {
                final MutableMap<V, E> walked = GoodMutableMapFactory.getInstance().create(); // TODO factory to parameter.
                BFS.traverse(adj, SingleElementCollection.create(start), new BFSVisitor<V, E>() {
                    @Override
                    public void onDiscover(V vertex, int d, VisitorStopper s) {
                        if (vertex.equals(target))
                            s.stop();
                    }

                    @Override
                    public void onWalk(E e) {
                        walked.add(e.to(), e); // TODO stopping here is more intuitive
                    }
                });
                if (!walked.containsKey(target))
                    return def;
                return extractPath(target, walked);
            }

        };
    }

    private static <V, E extends DirectedEdge<V>> Collection<E> extractPath(final V target, final MutableMap<V, E> walked) {
        List<E> a = new ArrayList<>();
        V cur = target;
        while (walked.containsKey(cur)) {
            E e = walked.get(cur);
            a.add(e);
            cur = e.from();
        }
        return a;
    }

}
