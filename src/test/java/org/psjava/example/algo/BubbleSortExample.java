package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.sequence.sort.BubbleSort;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.util.DefaultComparator;

/**
 * @implementation {@link BubbleSort}
 * @see {@link SortingAlgorithmExample}
 */
public class BubbleSortExample {
    @Test
    public void example() {
        MutableArray<Integer> array = MutableArrayFromVarargs.create(2, 1, 3);
        BubbleSort.getInstance().sort(array, new DefaultComparator<Integer>());
        Assert.assertEquals("(1,2,3)", array.toString());
    }
}
