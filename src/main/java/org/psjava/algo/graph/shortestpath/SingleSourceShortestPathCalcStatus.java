package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

public class SingleSourceShortestPathCalcStatus<V, W> {
	public final MutableMap<V, W> distance = GoodMutableMapFactory.getInstance().create();
	public final MutableMap<V, DirectedWeightedEdge<V, W>> previous = GoodMutableMapFactory.getInstance().create();
}