package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.sequence.sort.RandomizedQuicksort;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.example.ds.ArrayExample;
import org.psjava.util.DefaultComparator;

/**
 * @implementation {@link RandomizedQuicksort}
 * @see {@link SortingAlgorithmExample}
 * @see {@link ArrayExample}
 */
public class QuicksortExample {
    @Test
    public void example() {
        MutableArray<Integer> array = MutableArrayFromVarargs.create(2, 1, 3);
        RandomizedQuicksort.getInstance().sort(array, new DefaultComparator<Integer>());
        Assert.assertEquals("(1,2,3)", array.toString());
    }
}
