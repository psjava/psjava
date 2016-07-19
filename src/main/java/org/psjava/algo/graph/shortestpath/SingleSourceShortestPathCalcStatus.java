package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.map.MutableMap;
import org.psjava.ds.numbersystrem.InfinitableNumber;
import org.psjava.goods.GoodMutableMapFactory;

public class SingleSourceShortestPathCalcStatus<V, W, E> {
    public final MutableMap<V, InfinitableNumber<W>> distance = GoodMutableMapFactory.getInstance().create();
    public final MutableMap<V, E> previous = GoodMutableMapFactory.getInstance().create();
}