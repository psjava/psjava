package org.psjava.goods;

import org.psjava.algo.graph.shortestpath.AllPairShortestPathV2;
import org.psjava.algo.graph.shortestpath.BellmanFordAlgorithm;
import org.psjava.algo.graph.shortestpath.JohnsonAlgorithm;

public class GoodJohnsonAlgorithm {
    public static AllPairShortestPathV2 getInstance() {
        return JohnsonAlgorithm.getInstance(BellmanFordAlgorithm.getInstance(), GoodDijkstraAlgorithm.getInstanceV2());
    }
}
