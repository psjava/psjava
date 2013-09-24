package org.psjava.algo.graph.shortestpath;

import java.util.LinkedList;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.map.Map;
import org.psjava.javautil.AssertStatus;

public class SingleSourceShortestPathResultFactory {

	public static <V, W> SingleSourceShortestPathResult<V, W> create(final V start, final Map<V, W> distance, final Map<V, DirectedWeightedEdge<V, W>> previous) {
		return new SingleSourceShortestPathResult<V, W>() {
			@Override
			public W getDistance(V to) {
				assertReachable(to);
				return distance.get(to);
			}

			@Override
			public Iterable<DirectedWeightedEdge<V, W>> getPath(V to) {
				assertReachable(to);
				LinkedList<DirectedWeightedEdge<V, W>> r = new LinkedList<DirectedWeightedEdge<V, W>>();
				for (V v = to; !v.equals(start); v = previous.get(v).from())
					r.addFirst(previous.get(v));
				return r;
			}

			@Override
			public boolean isReachable(V to) {
				return distance.get(to) != null;
			}

			private void assertReachable(V to) {
				AssertStatus.assertTrue(isReachable(to), "Not reachable");
			}
		};
	}

}
