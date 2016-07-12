package org.psjava.goods;

import org.psjava.algo.DijkstraAlgorithmV2;
import org.psjava.algo.SingleSourceShortestPathAlgorithm;
import org.psjava.ds.heap.BinaryHeapFactory;

public class GoodDijkstraAlgorithm {
    public static SingleSourceShortestPathAlgorithm getInstance() {
        return DijkstraAlgorithmV2.getInstance(BinaryHeapFactory.getInstance(), GoodMutableMapFactory.getInstance());
    }
}
