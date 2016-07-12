package org.psjava.goods;

import org.psjava.algo.SingleSourceShortestPathAlgorithm;

public class GoodSingleSourceShortestPathAlgorithm {
    public static SingleSourceShortestPathAlgorithm getInstance() {
        return GoodDijkstraAlgorithm.getInstance();
    }
}
