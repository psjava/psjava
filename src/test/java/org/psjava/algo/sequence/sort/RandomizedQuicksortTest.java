package org.psjava.algo.sequence.sort;

import org.junit.Test;
import org.psjava.algo.sequence.sort.RandomizedQuicksort;

public class RandomizedQuicksortTest {

    @Test
    public void test() {
        SortingAlgorithmTestCommon.testSimpleSort(RandomizedQuicksort.getInstance());
    }

}
