package org.psjava.algo.graph.shortestpath;

import java.util.LinkedList;
import java.util.function.Function;

import org.psjava.algo.AllPairShortestPath;
import org.psjava.ds.graph.AllEdgeInGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.numbersystrem.AddableNumberSystem;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.util.Assertion;
import org.psjava.util.Pair;

public class FloydWarshallAlgorithm {

    private static class Status<V, E, W> {
        W distance = null;
        V next = null;
        E directEdge = null;
    }

    public static final AllPairShortestPath INSTANCE = new AllPairShortestPath() {
        @Override
        public <V, W, E extends DirectedEdge<V>> AllPairShortestPathResult<V, W, E> calc(Graph<V, E> graph, Function<E, W> weight, AddableNumberSystem<W> ns) {
            MutableMap<Pair<V, V>, Status<V, E, W>> status = GoodMutableMapFactory.getInstance().create();

            for (V v1 : graph.getVertices())
                for (V v2 : graph.getVertices())
                    status.add(Pair.create(v1, v2), new Status<V, E, W>());

            for (V v : graph.getVertices())
                status.get(Pair.create(v, v)).distance = ns.getZero();

            for (E edge : AllEdgeInGraph.wrap(graph)) {
                Status<V, E, W> s = status.get(Pair.create(edge.from(), edge.to()));
                if (s.distance == null || ns.compare(s.distance, weight.apply(edge)) > 0) {
                    s.distance = weight.apply(edge);
                    s.directEdge = edge;
                }
            }

            for (V k : graph.getVertices())
                for (V i : graph.getVertices())
                    for (V j : graph.getVertices()) {
                        Status<V, E, W> i2k = status.get(Pair.create(i, k));
                        Status<V, E, W> k2j = status.get(Pair.create(k, j));
                        if (i2k.distance != null && k2j.distance != null) {
                            W newd = ns.add(i2k.distance, k2j.distance);
                            Status<V, E, W> s = status.get(Pair.create(i, j));
                            if (s.distance == null || ns.compare(s.distance, newd) > 0) {
                                s.distance = newd;
                                s.next = k;
                            }
                        }
                    }

            for (V k : graph.getVertices())
                Assertion.ensure(!ns.isNegative(status.get(Pair.create(k, k)).distance), "contains negative cycle");

            return createResult(status);
        }
    };

    private static <V, W, E> AllPairShortestPathResult<V, W, E> createResult(final MutableMap<Pair<V, V>, Status<V, E, W>> status) {
        return new AllPairShortestPathResult<V, W, E>() {

            @Override
            public Iterable<E> getPath(V from, V to) {
                assertReachable(from, to);
                LinkedList<E> list = new LinkedList<E>();
                getPathRecursively(list, from, to);
                return list;
            }

            private void getPathRecursively(LinkedList<E> list, V from, V to) {
                if (!from.equals(to)) {
                    Status<V, E, W> s = status.get(Pair.create(from, to));
                    if (s.next == null) {
                        list.add(s.directEdge);
                    } else {
                        getPathRecursively(list, from, s.next);
                        getPathRecursively(list, s.next, to);
                    }
                }
            }

            @Override
            public W getDistance(V from, V to) {
                assertReachable(from, to);
                return status.get(Pair.create(from, to)).distance;
            }

            private void assertReachable(V from, V to) {
                Assertion.ensure(isReachable(from, to), "not reachable");
            }

            @Override
            public boolean isReachable(V from, V to) {
                Status<V, E, W> s = status.getOrNull(Pair.create(from, to));
                Assertion.ensure(s != null, "not valid vertex");
                return s.distance != null;
            }

        };
    }
}
