package org.psjava.example;

import java.util.Comparator;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.algo.search.BinarySearchFirstInArray;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.javautil.DefaultComparator;
import org.psjava.javautil.ReversedComparator;

public class BinarySearchExample {

	@Test
	public void example() {

		// Search 5 in increasing int sequence. result is the position. so 2

		MutableArray<Integer> array1 = MutableArrayFromValues.create(1, 3, 5, 7, 9);
		int res1 = BinarySearchFirstInArray.search(array1, new DefaultComparator<Integer>(), 5, -1);

		// This is a example in decresing sequence. You can use the reversed
		// comparator.

		MutableArray<Integer> array2 = MutableArrayFromValues.create(9, 7, 5, 3, 1);
		Comparator<Integer> comp = ReversedComparator.wrap(new DefaultComparator<Integer>());
		int res2 = BinarySearchFirstInArray.search(array2, comp, 3, -1);

		// You don't have to have a array. just a function

		Assert.assertEquals(2, res1);
		Assert.assertEquals(3, res2);
	}

}
