package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.numbersystrem.InfinitableAddableNumberSystem;
import org.psjava.ds.numbersystrem.InfinitableNumber;

public class Relax {

	public static <V, W, E extends DirectedWeightedEdge<V, W>> boolean relax(MutableMap<V, InfinitableNumber<W>> distance, MutableMap<V, E> previous, E edge, InfinitableAddableNumberSystem<W> ns) {
		InfinitableNumber<W> fromDistance = distance.get(edge.from());
		if (fromDistance.isInfinity())
			return false;

		InfinitableNumber<W> weight = InfinitableNumber.getFiniteInstance(edge.weight());
		InfinitableNumber<W> oldDistance = distance.get(edge.to());
		InfinitableNumber<W> newDistance = ns.add(fromDistance, weight);
		if (ns.compare(oldDistance, newDistance) > 0) {
			distance.replace(edge.to(), newDistance);
			previous.addOrReplace(edge.to(), edge);
			return true;
		}
		return false;
	}

	private Relax() {
	}

}
