package org.psjava.goods;

import org.psjava.algo.DijkstraAlgorithm;
import org.psjava.algo.SingleSourceShortestPathAlgorithm;
import org.psjava.ds.heap.BinaryHeapFactory;

public class GoodDijkstraAlgorithm {
    public static SingleSourceShortestPathAlgorithm getInstance() {
        return DijkstraAlgorithm.getInstance(BinaryHeapFactory.getInstance(), GoodMutableMapFactory.getInstance());
    }
}
