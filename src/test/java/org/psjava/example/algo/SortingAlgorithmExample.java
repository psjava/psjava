package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.sequence.sort.MergeSort;
import org.psjava.algo.sequence.sort.SortingHelper;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromVarargs;
import org.psjava.util.DefaultComparator;

/**
 * @see {@link QuicksortExample}
 * @see {@link InsertionSortExample}
 * @see {@link BubbleSortExample}
 * @see {@link MergeSortExample}
 */
public class SortingAlgorithmExample {
    @Test
    public void example() {

        // Following example is a normal usage.

        MutableArray<Integer> array1 = MutableArrayFromVarargs.create(2, 1, 3);
        MergeSort.getInstance().sort(array1, new DefaultComparator<Integer>());
        Assert.assertEquals("(1,2,3)", array1.toString());

        // There is only one method in the 'Sort' interface,
        // but there are several convenient methods in 'SortHelper' class
        // Following is a partial sorting example.

        MutableArray<Integer> array2 = MutableArrayFromVarargs.create(100, 3, 2, 1, 0);
        SortingHelper.sort(MergeSort.getInstance(), array2, 1, 4);
        Assert.assertEquals("(100,1,2,3,0)", array2.toString());
    }
}
