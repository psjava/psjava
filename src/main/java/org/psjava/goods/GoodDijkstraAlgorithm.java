package org.psjava.goods;

import org.psjava.algo.DijkstraAlgorithmV2;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathAlgorithmUsingV2;
import org.psjava.ds.heap.BinaryHeapFactory;

@Deprecated
public class GoodDijkstraAlgorithm {

    @Deprecated
    public static SingleSourceShortestPathAlgorithm getInstance() {
        return SingleSourceShortestPathAlgorithmUsingV2.wrap(DijkstraAlgorithmV2.getInstance(BinaryHeapFactory.getInstance(), GoodMutableMapFactory.getInstance()));
    }

    private GoodDijkstraAlgorithm() {
    }

}
