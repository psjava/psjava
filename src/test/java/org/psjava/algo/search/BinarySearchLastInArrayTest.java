package org.psjava.algo.search;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.Array;
import org.psjava.ds.array.MutableArrayUsingIntArray;
import org.psjava.javautil.DefaultComparator;


public class BinarySearchLastInArrayTest {

	private static final DefaultComparator<Integer> COMP = new DefaultComparator<Integer>();

	@Test
	public void test() {
		Array<Integer> a = MutableArrayUsingIntArray.wrap(new int[] { 1, 3, 3, 5, 7, 9 });
		Assert.assertEquals(2, BinarySearchLastInArray.search(a, 3, COMP, -1));
		Assert.assertEquals(-1, BinarySearchLastInArray.search(a, 6, COMP, -1));
	}

}
