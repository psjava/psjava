package org.psjava.algo.graph.mst;

import org.psjava.algo.graph.mst.MinimumSpanningTreeAlgorithmTestBase;
import org.psjava.goods.GoodSortingAlgorithm;

public class KruscalAlgorithmTest extends MinimumSpanningTreeAlgorithmTestBase {

    public MinimumSpanningTreeAlgorithm getInstance() {
        return KruscalAlgorithm.getInstance(GoodSortingAlgorithm.getInstance());
    }

}
