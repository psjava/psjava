package org.psjava.algo.graph.mst;

import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.goods.GoodMutableMapFactory;

public class PrimAlgorithmTest extends MinimumSpanningTreeAlgorithmTestBase {

    public MinimumSpanningTreeAlgorithm getInstance() {
        return PrimAlgorithm.getInstance(BinaryHeapFactory.getInstance(), GoodMutableMapFactory.getInstance());
    }

}
