package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class Relax {

	public static <V, W, E extends DirectedWeightedEdge<V, W>> boolean relax(MutableMap<V, W> distance, MutableMap<V, E> previous, E edge, AddableNumberSystem<W> ns) {
		W fromDistance = distance.get(edge.from());
		if (fromDistance == null)
			return false;

		W oldDistance = distance.get(edge.to());
		W newDistance = ns.add(fromDistance, edge.weight());
		if (NullableDistanceCompare.compare(ns, oldDistance, newDistance) > 0) {
			distance.put(edge.to(), newDistance);
			previous.put(edge.to(), edge);
			return true;
		}
		return false;
	}

	private Relax() {
	}

}
