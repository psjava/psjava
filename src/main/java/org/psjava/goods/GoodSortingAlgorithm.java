package org.psjava.goods;

import org.psjava.algo.sequence.sort.RandomizedQuicksort;
import org.psjava.algo.sequence.sort.SortingAlgorithm;

public class GoodSortingAlgorithm {

    private static final SortingAlgorithm INSTANCE = RandomizedQuicksort.getInstance();

    public static SortingAlgorithm getInstance() {
        return INSTANCE;
    }

    private GoodSortingAlgorithm() {
    }
}
