package org.psjava.algo.graph.shortestpath;

import java.util.LinkedList;
import java.util.List;


import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.map.DataGetterFromMap;
import org.psjava.ds.map.Map;
import org.psjava.javautil.AssertStatus;
import org.psjava.javautil.DataGetter;

public class SingleSourceShortestPathResultFactory {

	public static <E extends DirectedWeightedEdge<W>, W> SingleSourceShortestPathResult<W, E> wrap(final Object start, final Map<Object, W> distance, final Map<Object, E> previous) {
		return new SingleSourceShortestPathResult<W, E>() {
			@Override
			public W getDistance(Object to) {
				assertReachable(to);
				return distance.get(to);
			}
			@Override
			public Iterable<E> getEdgePath(Object to) {
				assertReachable(to);
				return SingleSourceShortestPathResultFactory.extractPath(start, to, DataGetterFromMap.wrap(previous));
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

	// TODO inline later.
	public static <E extends DirectedEdge> List<E> extractPath(final Object start, Object to, DataGetter<Object, E> previous) {
		LinkedList<E> r = new LinkedList<E>();
		for(Object v = to; !v.equals(start); v = previous.get(v).from())
			r.addFirst(previous.get(v));
		return r;
	}

}
