package org.psjava.algo.search;

import java.util.Comparator;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.ds.array.MutableArrayUsingIntArray;
import org.psjava.javautil.DefaultComparator;
import org.psjava.javautil.ReversedComparator;

public class BinarySearchExample {

	@Test
	public void searchInNormalArray() {
		int[] array = new int[] { 1, 3, 5, 7, 9 };
		int res = BinarySearchFirstInArray.search(MutableArrayUsingIntArray.wrap(array), 5, new DefaultComparator<Integer>(), -1);
		Assert.assertEquals(2, res);
	}

	@Test
	public void searchInReversedArray() {
		int[] array = new int[] { 9, 7, 5, 3, 1 };
		Comparator<Integer> comp = ReversedComparator.wrap(new DefaultComparator<Integer>());
		int res = BinarySearchFirstInArray.search(MutableArrayUsingIntArray.wrap(array), 3, comp, -1);
		Assert.assertEquals(3, res);
	}

}
