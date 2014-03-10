package org.psjava.example.algo;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.sequence.sort.BubbleSort;
import org.psjava.algo.sequence.sort.InsertionSort;
import org.psjava.algo.sequence.sort.MergeSort;
import org.psjava.algo.sequence.sort.RandomizedQuicksort;
import org.psjava.algo.sequence.sort.SortingHelper;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.goods.GoodSortingAlgorithm;
import org.psjava.util.DefaultComparator;

/**
 * @see {@link QuicksortExample}
 * @see {@link InsertionSortExample}
 * @see {@link BubbleSortExample}
 * @see {@link MergeSortExample}
 */
public class SortExample {
	@Test
	public void example() {

		// Following example is normal usage.

		MutableArray<Integer> array1 = MutableArrayFromValues.create(2, 1, 3);
		MergeSort.getInstance().sort(array1, new DefaultComparator<Integer>());

		// There is only one method in Sort interface,
		// but there are several convenient methods in SortHelper class
		// Following is partial sorting.

		MutableArray<Integer> array2 = MutableArrayFromValues.create(100, 3, 2, 1, 0);
		SortingHelper.sort(MergeSort.getInstance(), array2, 1, 4);

		// There are several implementations.
		RandomizedQuicksort.getInstance();
		InsertionSort.getInstance();
		BubbleSort.getInstance();
		MergeSort.getInstance();
		GoodSortingAlgorithm.getInstance(); // We choose a good one for you.

		Assert.assertEquals("(1,2,3)", array1.toString());
		Assert.assertEquals("(100,1,2,3,0)", array2.toString());
	}
}
