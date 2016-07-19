package org.psjava.goods;

import org.psjava.algo.graph.mst.KruscalAlgorithm;
import org.psjava.algo.graph.mst.MinimumSpanningTreeAlgorithm;

public class GoodMinimumSpanningTreeAlgorithm {

    public static MinimumSpanningTreeAlgorithm getInstance() {
        return KruscalAlgorithm.getInstance(GoodSortingAlgorithm.getInstance());
    }

    private GoodMinimumSpanningTreeAlgorithm() {
    }

}
