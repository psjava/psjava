package org.psjava.example;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.search.BinarySearchFirst;
import org.psjava.algo.search.BinarySearchFirstFalse;
import org.psjava.algo.search.BinarySearchFirstInArray;
import org.psjava.algo.search.BinarySearchFirstTrue;
import org.psjava.algo.search.BinarySearchLast;
import org.psjava.algo.search.BinarySearchLastFalse;
import org.psjava.algo.search.BinarySearchLastInArray;
import org.psjava.algo.search.BinarySearchLastTrue;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.javautil.DefaultComparator;
import org.psjava.javautil.ReversedComparator;
import org.psjava.math.Function;
import org.psjava.math.ns.IntegerNumberSystem;

public class BinarySearchExample {

	@Test
	public void example() {

		// Search a value 5 in increasing int array. result is the position = 2

		MutableArray<Integer> array1 = MutableArrayFromValues.create(1, 3, 5, 7, 9);
		int res1 = BinarySearchFirstInArray.search(array1, new DefaultComparator<Integer>(), 5, -1);


		// Following is an example for decresing array.
		// You can use the reversed comparator.

		MutableArray<Integer> array2 = MutableArrayFromValues.create(9, 7, 5, 3, 1);
		int res2 = BinarySearchFirstInArray.search(array2, ReversedComparator.wrap(new DefaultComparator<Integer>()), 3, -1);


		// You don't have to prepare an array. Any function is enough.
		
		int res3 = BinarySearchFirst.search(IntegerNumberSystem.getInstance(), new Function<Integer, Integer>() {
			@Override
			public Integer get(Integer input) {
				return input * 8;
			}
		}, new DefaultComparator<Integer>(), 100, 200, 888, -1);


		// And, there are many alternatives. check them

		BinarySearchFirst.class.getClass();
		BinarySearchFirstTrue.class.getClass();
		BinarySearchFirstFalse.class.getClass();
		BinarySearchFirstInArray.class.getClass();
		BinarySearchLast.class.getClass();
		BinarySearchLastInArray.class.getClass();
		BinarySearchLastTrue.class.getClass();
		BinarySearchLastFalse.class.getClass();
		
		
		

		// these are assertion
		Assert.assertEquals(2, res1);
		Assert.assertEquals(3, res2);
		Assert.assertEquals(111, res3);
	}

}
