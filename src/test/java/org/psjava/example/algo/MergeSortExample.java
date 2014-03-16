package org.psjava.example.algo;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.sequence.sort.MergeSort;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.util.DefaultComparator;

/**
 * @implementation {@link MergeSort}
 * @see {@link SortingAlgorithmExample}
 */
public class MergeSortExample {
	@Test
	public void example() {
		MutableArray<Integer> array = MutableArrayFromValues.create(2, 1, 3);
		MergeSort.getInstance().sort(array, new DefaultComparator<Integer>());
		Assert.assertEquals("(1,2,3)", array.toString());
	}
}
