package org.psjava.algo.sequence.sort;

import org.junit.Assert;

import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.util.DefaultComparator;

public class SortingAlgorithmTestCommon {

    public static void testSimpleSort(SortingAlgorithm sort) {
        MutableArray<Integer> a = MutableArrayFromVarargs.create(2, 3, 1);
        sort.sort(a, new DefaultComparator<Integer>());
        Assert.assertEquals(MutableArrayFromVarargs.create(1, 2, 3), a);
    }

}
