package org.psjava.goods;

import org.psjava.algo.SingleSourceShortestPathAlgorithmV2;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathAlgorithm;

public class GoodSingleSourceShortestPathAlgorithm {

    @Deprecated
    public static SingleSourceShortestPathAlgorithm getInstance() {
        return GoodDijkstraAlgorithm.getInstance();
    }

    public static SingleSourceShortestPathAlgorithmV2 getInstanceV2() {
        return GoodDijkstraAlgorithm.getInstanceV2();
    }
}
