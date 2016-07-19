package org.psjava.algo.sequence.sort;

import org.junit.Test;
import org.psjava.algo.sequence.sort.InsertionSort;

public class InsertionSortTest {
    @Test
    public void test() {
        SortingAlgorithmTestCommon.testSimpleSort(InsertionSort.getInstance());
    }
}
