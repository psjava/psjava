package org.psjava.goods;

import org.psjava.algo.DijkstraAlgorithmV2;
import org.psjava.algo.SingleSourceShortestPathAlgorithmV2;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathAlgorithmUsingV2;
import org.psjava.ds.heap.BinaryHeapFactory;

public class GoodDijkstraAlgorithm {

    @Deprecated
    public static SingleSourceShortestPathAlgorithm getInstance() {
        return SingleSourceShortestPathAlgorithmUsingV2.wrap(getInstanceV2());
    }

    public static SingleSourceShortestPathAlgorithmV2 getInstanceV2() {
        return DijkstraAlgorithmV2.getInstance(BinaryHeapFactory.getInstance(), GoodMutableMapFactory.getInstance());
    }

    private GoodDijkstraAlgorithm() {
    }

}
