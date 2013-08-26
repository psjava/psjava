package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

public class SingleSourceShortestPathCalcStatus<W> {
	public final MutableMap<Object, W> distance = GoodMutableMapFactory.getInstance().create();
	public final MutableMap<Object, DirectedWeightedEdge<W>> previous = GoodMutableMapFactory.getInstance().create();
}