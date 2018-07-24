package org.psjava.algo.graph.shortestpath;

import java.util.LinkedList;

import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.map.PSMap;
import org.psjava.ds.numbersystrem.InfinitableNumber;
import org.psjava.util.VarargsToString;
import org.psjava.util.Assertion;

public class SingleSourceShortestPathResultFactory {

    // TODO inline
    public static <V, E extends DirectedEdge<V>, W> SingleSourceShortestPathResult<V, W, E> create(final V start, final PSMap<V, InfinitableNumber<W>> distance, final PSMap<V, E> previous) {
        return new SingleSourceShortestPathResult<V, W, E>() {
            @Override
            public W getDistance(V to) {
                assertReachable(to);
                return distance.get(to).getValue();
            }

            @Override
            public Iterable<E> getPath(V to) {
                assertReachable(to);
                LinkedList<E> r = new LinkedList<E>();
                for (V v = to; !v.equals(start); v = previous.get(v).from())
                    r.addFirst(previous.get(v));
                return r;
            }

            @Override
            public boolean isReachable(V to) {
                return !distance.get(to).isInfinity();
            }

            private void assertReachable(V to) {
                Assertion.ensure(isReachable(to), "Not reachable");
            }

            @Override
            public String toString() {
                return VarargsToString.toString(distance, previous);
            }
        };
    }

    private SingleSourceShortestPathResultFactory() {
    }

}
