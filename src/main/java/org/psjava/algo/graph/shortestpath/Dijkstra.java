package org.psjava.algo.graph.shortestpath;


import java.util.Comparator;

import org.psjava.ds.graph.DirectedAdjacencyListableGraph;
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
	public <W, E extends DirectedWeightedEdge<W>> SingleSourceShortestPathResult<W, E> calc(DirectedAdjacencyListableGraph<E> g, Object start, final AddableNumberSystem<W> ns) {
		final MutableMap<Object, W> distance = MF.create();
		MutableMap<Object, E> previous = MF.create();
		
		for(Object v : g.getVertices())
			distance.put(v, null); // null means infinity
		distance.put(start, ns.getZero());

		Heap<Object> heap = factory.create(new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				return comp(ns, distance.get(o1), distance.get(o2));
			}
		});
		
		MutableMap<Object, HeapNode<Object>> node = MF.create();
		for(Object v : g.getVertices()) 
			node.put(v, heap.insert(v));
		
		while(!heap.isEmpty()) {
			Object current = heap.extractMinimum();
			W currentDistance = distance.get(current);
			if(currentDistance == null) // infinity
				break;
			for(E edge : g.getOutEdges(current)) {
				W newDistance = ns.add(currentDistance, edge.weight());
				Object next = edge.to();
				if(comp(ns, newDistance, distance.get(next)) < 0){
					distance.put(next, newDistance);
					previous.put(next, edge);
					node.get(next).decreaseKey(next);
				}
			}
		}
		
		return SingleSourceShortestPathResultFactory.wrap(start, distance, previous);
	}

	private <W> int comp(final AddableNumberSystem<W> ns, W d1, W d2) {
		return NullableDistanceCompare.compare(ns, d1, d2);
	}

}