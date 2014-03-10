package org.psjava.example.algo;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.sequence.search.BinarySearchFirst;
import org.psjava.algo.sequence.search.BinarySearchFirstFalse;
import org.psjava.algo.sequence.search.BinarySearchFirstInArray;
import org.psjava.algo.sequence.search.BinarySearchFirstTrue;
import org.psjava.algo.sequence.search.BinarySearchLast;
import org.psjava.algo.sequence.search.BinarySearchLastFalse;
import org.psjava.algo.sequence.search.BinarySearchLastInArray;
import org.psjava.algo.sequence.search.BinarySearchLastTrue;
import org.psjava.ds.array.Array;
import org.psjava.ds.array.ArrayFromValues;
import org.psjava.ds.math.Function;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.util.DefaultComparator;
import org.psjava.util.ReversedComparator;

/**
 * @implementation {@link BinarySearchFirst}
 */
public class BinarySearchExample {

	@Test
	public void example() {

		// Let's search 5 in increasing integer array.

		Array<Integer> array1 = ArrayFromValues.create(1, 3, 5, 7, 9);
		// Result is 2, the index of 5 in the array.
		int index1 = BinarySearchFirstInArray.search(array1, new DefaultComparator<Integer>(), 5, -1);

		// Following is an example for decreasing array.
		// In the example, you can use a reversed comparator.

		Array<Integer> array2 = ArrayFromValues.create(9, 7, 5, 3, 1);
		int index2 = BinarySearchFirstInArray.search(array2, ReversedComparator.wrap(new DefaultComparator<Integer>()), 3, -1);

		// You don't have to prepare an array. Any function is enough.
		// Set the function as 'y=8x'.

		Function<Integer, Integer> func = new Function<Integer, Integer>() {
			@Override
			public Integer get(Integer index) {
				return index * 8;
			}
		};
		// x for 888 is 111
		int index3 = BinarySearchFirst.search(IntegerNumberSystem.getInstance(), func, new DefaultComparator<Integer>(), 100, 200, 888, -1);

		Assert.assertEquals(111, index3);

		// And, there are many alternatives interfaces. check them

		BinarySearchFirst.class.getClass();
		BinarySearchFirstTrue.class.getClass();
		BinarySearchFirstFalse.class.getClass();
		BinarySearchFirstInArray.class.getClass();
		BinarySearchLast.class.getClass();
		BinarySearchLastInArray.class.getClass();
		BinarySearchLastTrue.class.getClass();
		BinarySearchLastFalse.class.getClass();

		Assert.assertEquals(2, index1);
		Assert.assertEquals(3, index2);
	}

}
