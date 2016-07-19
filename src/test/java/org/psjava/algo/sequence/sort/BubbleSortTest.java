package org.psjava.algo.sequence.sort;

import org.junit.Test;
import org.psjava.algo.sequence.sort.BubbleSort;

public class BubbleSortTest {
    @Test
    public void test() {
        SortingAlgorithmTestCommon.testSimpleSort(BubbleSort.getInstance());
    }
}
