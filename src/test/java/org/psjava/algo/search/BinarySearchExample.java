package org.psjava.algo.search;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.ds.array.MutableArrayUsingIntArray;
import org.psjava.javautil.DefaultComparator;

public class BinarySearchExample {

	// TODO complemet cases

	@Test
	public void searchInNormalArray() {
		int[] a = { 1, 3, 5, 7, 9 };
		int res = BinarySearchFirstInArray.search(MutableArrayUsingIntArray.wrap(a), 5, new DefaultComparator<Integer>(), -1);
		Assert.assertEquals(2, res);
	}

	@Test
	public void searchInReversedArray() {
		int[] a = { 9, 7, 5, 3, 1 };
		int res = BinarySearchFirstInArray.search(MutableArrayUsingIntArray.wrap(a), 3, new DefaultComparator<Integer>(), -1);
		Assert.assertEquals(3, res);
	}

}
