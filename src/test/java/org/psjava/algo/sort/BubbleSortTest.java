package org.psjava.algo.sort;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.javautil.DefaultComparator;


public class BubbleSortTest {
	@Test
	public void test() {
		MutableArray<Integer> a = MutableArrayFromValues.create(2, 3, 1);
		BubbleSort.getInstance().sort(a, new DefaultComparator<Integer>());
		Assert.assertEquals(MutableArrayFromValues.create(1, 2, 3), a);
	}
}
