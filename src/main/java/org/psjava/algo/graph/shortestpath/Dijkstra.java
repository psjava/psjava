package org.psjava.algo.graph.shortestpath;

import java.util.Comparator;

import org.psjava.ds.graph.IndexedEdgesByFrom;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.Graph;
import org.psjava.ds.heap.Heap;
import org.psjava.ds.heap.HeapFactory;
import org.psjava.ds.heap.HeapNode;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.goods.GoodMutableMapFactory;
import org.psjava.math.ns.AddableNumberSystem;

public class Dijkstra implements SingleSourceShortestPath {

	// TODO assert negative weight.
	// TODO check performance, and use int indexed graph if it needs.

	private static final MutableMapFactory MF = GoodMutableMapFactory.getInstance();

	private HeapFactory factory;

	public Dijkstra(HeapFactory heapFactory) {
		this.factory = heapFactory;
	}

	@Override
	public <V, W, E extends DirectedWeightedEdge<V, W>> SingleSourceShortestPathResult<V, W, E> calc(Graph<V, E> graph, V start, final AddableNumberSystem<W> ns) {
		IndexedEdgesByFrom<V, E> edges = IndexedEdgesByFrom.create(graph);
		final MutableMap<V, W> distance = MF.create();
		MutableMap<V, E> previous = MF.create();

		for (V v : graph.getVertices())
			distance.put(v, null); // null means infinity
		distance.put(start, ns.getZero());

		Heap<V> heap = factory.create(new Comparator<V>() {
			@Override
			public int compare(V o1, V o2) {
				return NullableDistanceCompare.compare(ns, distance.get(o1), distance.get(o2));
			}
		});

		MutableMap<V, HeapNode<V>> node = MF.create();
		for (V v : graph.getVertices())
			node.put(v, heap.insert(v));

		while (!heap.isEmpty()) {
			V current = heap.extractMinimum();
			for (E edge : edges.getEdges(current)) {
				boolean relaxed = Relax.relax(distance, previous, edge, ns);
				if (relaxed)
					node.get(edge.to()).decreaseKey(edge.to());
			}
		}

		return SingleSourceShortestPathResultFactory.create(start, distance, previous);
	}

}