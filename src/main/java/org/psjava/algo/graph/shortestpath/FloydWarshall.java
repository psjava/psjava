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

	private static class Status<W> {
		W distance = null;
		Object next = null;
		DirectedWeightedEdge<W> directEdge = null;
	}

	@Override
	public <W> AllPairShortestPathResult<W> calc(DirectedWeightedGraph<W> graph, AddableNumberSystem<W> ns) {
		MutableMap<Pair<Object, Object>, Status<W>> status = GoodMutableMapFactory.getInstance().create();

		for (Object v1 : graph.getVertices())
			for (Object v2 : graph.getVertices())
				status.put(Pair.create(v1, v2), new Status<W>());

		for (Object v : graph.getVertices())
			status.get(Pair.create(v, v)).distance = ns.getZero();

		for (DirectedWeightedEdge<W> edge : graph.getEdges()) {
			Status<W> s = status.get(Pair.create(edge.from(), edge.to()));
			if (s.distance == null || ns.compare(s.distance, edge.weight()) > 0) {
				s.distance = edge.weight();
				s.directEdge = edge;
			}
		}

		for (Object k : graph.getVertices())
			for (Object i : graph.getVertices())
				for (Object j : graph.getVertices()) {
					Status<W> i2k = status.get(Pair.create(i, k));
					Status<W> k2j = status.get(Pair.create(k, j));
					if (i2k.distance != null && k2j.distance != null) {
						W newd = ns.add(i2k.distance, k2j.distance);
						Status<W> s = status.get(Pair.create(i, j));
						if (s.distance == null || ns.compare(s.distance, newd) > 0) {
							s.distance = newd;
							s.next = k;
						}
					}
				}

		for (Object k : graph.getVertices())
			AssertStatus.assertTrue(!ns.isNegative(status.get(Pair.create(k, k)).distance), "contains negative cycle");

		return createResult(status);
	}

	private <W> AllPairShortestPathResult<W> createResult(final MutableMap<Pair<Object, Object>, Status<W>> status) {
		return new AllPairShortestPathResult<W>() {

			@Override
			public Iterable<DirectedWeightedEdge<W>> getPath(Object from, Object to) {
				assertReachable(from, to);
				LinkedList<DirectedWeightedEdge<W>> list = new LinkedList<DirectedWeightedEdge<W>>();
				getPathRecursively(list, from, to);
				return list;
			}

			private void getPathRecursively(LinkedList<DirectedWeightedEdge<W>> list, Object from, Object to) {
				if (!from.equals(to)) {
					Status<W> s = status.get(Pair.create(from, to));
					if (s.next == null) {
						list.add(s.directEdge);
					} else {
						getPathRecursively(list, from, s.next);
						getPathRecursively(list, s.next, to);
					}
				}
			}

			@Override
			public W getDistance(Object from, Object to) {
				assertReachable(from, to);
				return status.get(Pair.create(from, to)).distance;
			}

			private void assertReachable(Object from, Object to) {
				AssertStatus.assertTrue(isReachable(from, to), "not reachable");
			}

			@Override
			public boolean isReachable(Object from, Object to) {
				Status<W> s = status.get(Pair.create(from, to), null);
				AssertStatus.assertTrue(s != null, "not valid vertex");
				return s.distance != null;
			}

		};
	}

}
