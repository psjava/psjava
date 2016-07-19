package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.sequence.sort.InsertionSort;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.util.DefaultComparator;

/**
 * @implementation {@link InsertionSort}
 * @see {@link SortingAlgorithmExample}
 */
public class InsertionSortExample {
    @Test
    public void example() {
        MutableArray<Integer> array = MutableArrayFromVarargs.create(2, 1, 3);
        InsertionSort.getInstance().sort(array, new DefaultComparator<Integer>());
        Assert.assertEquals("(1,2,3)", array.toString());
    }
}
