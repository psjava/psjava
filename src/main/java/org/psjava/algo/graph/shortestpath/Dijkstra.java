package org.psjava.algo.graph.shortestpath;

import java.util.Comparator;

import org.psjava.ds.graph.AdjacencyListableDirectedWeightedGraph;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.heap.Heap;
import org.psjava.ds.heap.HeapFactory;
import org.psjava.ds.heap.HeapNode;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.goods.GoodMutableMapFactory;
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
				return NullableDistanceCompare.compare(ns, distance.get(o1), distance.get(o2));
			}
		});

		MutableMap<Object, HeapNode<Object>> node = MF.create();
		for (Object v : graph.getVertices())
			node.put(v, heap.insert(v));

		while (!heap.isEmpty()) {
			Object current = heap.extractMinimum();
			for (DirectedWeightedEdge<W> edge : graph.getEdges(current)) {
				boolean relaxed = Relax.relax(distance, previous, edge, ns);
				if(relaxed)
					node.get(edge.to()).decreaseKey(edge.to());
			}
		}

		return SingleSourceShortestPathResultFactory.create(start, distance, previous);
	}

}