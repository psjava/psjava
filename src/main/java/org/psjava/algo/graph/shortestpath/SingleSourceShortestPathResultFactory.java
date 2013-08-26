package org.psjava.algo.graph.shortestpath;

import java.util.LinkedList;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.map.Map;
import org.psjava.javautil.AssertStatus;

public class SingleSourceShortestPathResultFactory {

	public static <W> SingleSourceShortestPathResult<W> create(final Object start, final Map<Object, W> distance, final Map<Object, DirectedWeightedEdge<W>> previous) {
		return new SingleSourceShortestPathResult<W>() {
			@Override
			public W getDistance(Object to) {
				assertReachable(to);
				return distance.get(to);
			}

			@Override
			public Iterable<DirectedWeightedEdge<W>> getPath(Object to) {
				assertReachable(to);
				LinkedList<DirectedWeightedEdge<W>> r = new LinkedList<DirectedWeightedEdge<W>>();
				for (Object v = to; !v.equals(start); v = previous.get(v).from())
					r.addFirst(previous.get(v));
				return r;
			}

			@Override
			public boolean isReachable(Object to) {
				return distance.get(to) != null;
			}

			private void assertReachable(Object to) {
				AssertStatus.assertTrue(isReachable(to), "Not reachable");
			}
		};
	}

}
