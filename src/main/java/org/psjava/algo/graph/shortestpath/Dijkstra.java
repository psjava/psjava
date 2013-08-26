package org.psjava.algo.graph.shortestpath;

import java.util.Comparator;
import java.util.LinkedList;

import org.psjava.ds.graph.AdjacencyListableDirectedWeightedGraph;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.heap.Heap;
import org.psjava.ds.heap.HeapFactory;
import org.psjava.ds.heap.HeapNode;
import org.psjava.ds.map.DataGetterFromMap;
import org.psjava.ds.map.Map;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.javautil.AssertStatus;
import org.psjava.math.ns.AddableNumberSystem;

public class Dijkstra implements SingleSourceShortestPath {

	private static final MutableMapFactory MF = GoodMutableMapFactory.getInstance();

	private HeapFactory factory;

	public Dijkstra(HeapFactory heapFactory) {
		this.factory = heapFactory;
	}

	@Override
	public <W> SingleSourceShortestPathResult<W> calc(AdjacencyListableDirectedWeightedGraph<W> graph, Object start, final AddableNumberSystem<W> ns) {
		final MutableMap<Object, W> distance = MF.create();
		MutableMap<Object, DirectedWeightedEdge<W>> previous = MF.create();

		for (Object v : graph.getVertices())
			distance.put(v, null); // null means infinity
		distance.put(start, ns.getZero());

		Heap<Object> heap = factory.create(new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				return comp(ns, distance.get(o1), distance.get(o2));
			}
		});

		MutableMap<Object, HeapNode<Object>> node = MF.create();
		for (Object v : graph.getVertices())
			node.put(v, heap.insert(v));

		while (!heap.isEmpty()) {
			Object current = heap.extractMinimum();
			W currentDistance = distance.get(current);
			if (currentDistance == null) // infinity
				break;
			for (DirectedWeightedEdge<W> edge : graph.getEdges(current)) {
				W newDistance = ns.add(currentDistance, edge.weight());
				Object next = edge.to();
				if (comp(ns, newDistance, distance.get(next)) < 0) {
					distance.put(next, newDistance);
					previous.put(next, edge);
					node.get(next).decreaseKey(next);
				}
			}
		}

		return Dijkstra.wrap(start, distance, previous);
	}

	private <W> int comp(final AddableNumberSystem<W> ns, W d1, W d2) {
		return NullableDistanceCompare.compare(ns, d1, d2);
	}

	public static <W> SingleSourceShortestPathResult<W> wrap(final Object start, final Map<Object, W> distance, final Map<Object, DirectedWeightedEdge<W>> previous) {
		// TODO use common code with bellmanford

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
				for (Object v = to; !v.equals(start); v = DataGetterFromMap.wrap(previous).get(v).from())
					r.addFirst(DataGetterFromMap.wrap(previous).get(v));
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