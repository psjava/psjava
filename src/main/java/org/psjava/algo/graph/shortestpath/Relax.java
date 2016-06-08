package org.psjava.algo.graph.shortestpath;

import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.InfinitableAddableNumberSystem;
import org.psjava.ds.numbersystrem.InfinitableNumber;

@Deprecated
public class Relax {

    public static <V, W, E extends DirectedWeightedEdge<V, W>> boolean relax(MutableMap<V, InfinitableNumber<W>> distance, MutableMap<V, E> previous, E edge, InfinitableAddableNumberSystem<W> ns) {
        return RelaxV2.relax(distance, previous, edge, new Function<E, W>() {
            @Override
            public W get(E input) {
                return input.weight();
            }
        }, ns);
    }

    private Relax() {
    }

}
