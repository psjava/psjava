package org.psjava.algo.graph.shortestpath;

import java.util.LinkedList;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.DirectedWeightedGraph;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.javautil.AssertStatus;
import org.psjava.javautil.Pair;
import org.psjava.math.ns.AddableNumberSystem;

public class FloydWarshall implements AllPairShortestPath {
	
	// TODO use int indexed graph for performance.

	private static class Status<V, W> {
		W distance = null;
		V next = null;
		DirectedWeightedEdge<V, W> directEdge = null;
	}

	@Override
	public <V, W> AllPairShortestPathResult<V, W> calc(DirectedWeightedGraph<V, W> graph, AddableNumberSystem<W> ns) {
		MutableMap<Pair<V, V>, Status<V, W>> status = GoodMutableMapFactory.getInstance().create();

		for (V v1 : graph.getVertices())
			for (V v2 : graph.getVertices())
				status.put(Pair.create(v1, v2), new Status<V, W>());

		for (V v : graph.getVertices())
			status.get(Pair.create(v, v)).distance = ns.getZero();

		for (DirectedWeightedEdge<V, W> edge : graph.getEdges()) {
			Status<V, W> s = status.get(Pair.create(edge.from(), edge.to()));
			if (s.distance == null || ns.compare(s.distance, edge.weight()) > 0) {
				s.distance = edge.weight();
				s.directEdge = edge;
			}
		}

		for (V k : graph.getVertices())
			for (V i : graph.getVertices())
				for (V j : graph.getVertices()) {
					Status<V, W> i2k = status.get(Pair.create(i, k));
					Status<V, W> k2j = status.get(Pair.create(k, j));
					if (i2k.distance != null && k2j.distance != null) {
						W newd = ns.add(i2k.distance, k2j.distance);
						Status<V, W> s = status.get(Pair.create(i, j));
						if (s.distance == null || ns.compare(s.distance, newd) > 0) {
							s.distance = newd;
							s.next = k;
						}
					}
				}

		for (V k : graph.getVertices())
			AssertStatus.assertTrue(!ns.isNegative(status.get(Pair.create(k, k)).distance), "contains negative cycle");

		return createResult(status);
	}

	private <V, W> AllPairShortestPathResult<V, W> createResult(final MutableMap<Pair<V, V>, Status<V, W>> status) {
		return new AllPairShortestPathResult<V, W>() {

			@Override
			public Iterable<DirectedWeightedEdge<V, W>> getPath(V from, V to) {
				assertReachable(from, to);
				LinkedList<DirectedWeightedEdge<V, W>> list = new LinkedList<DirectedWeightedEdge<V, W>>();
				getPathRecursively(list, from, to);
				return list;
			}

			private void getPathRecursively(LinkedList<DirectedWeightedEdge<V, W>> list, V from, V to) {
				if (!from.equals(to)) {
					Status<V, W> s = status.get(Pair.create(from, to));
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
				AssertStatus.assertTrue(isReachable(from, to), "not reachable");
			}

			@Override
			public boolean isReachable(V from, V to) {
				Status<V, W> s = status.get(Pair.create(from, to), null);
				AssertStatus.assertTrue(s != null, "not valid vertex");
				return s.distance != null;
			}

		};
	}

}
