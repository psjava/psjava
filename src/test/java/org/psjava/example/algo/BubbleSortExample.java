package org.psjava.example.algo;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.sequence.sort.BubbleSort;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.util.DefaultComparator;

/**
 * @implementation {@link BubbleSort}
 * @see {@link SortExample}
 */
public class BubbleSortExample {
	@Test
	public void example() {
		MutableArray<Integer> array = MutableArrayFromValues.create(2, 1, 3);
		BubbleSort.getInstance().sort(array, new DefaultComparator<Integer>());
		Assert.assertEquals("(1,2,3)", array.toString());
	}
}
