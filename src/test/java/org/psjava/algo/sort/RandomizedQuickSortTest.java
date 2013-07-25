package org.psjava.algo.sort;

import org.junit.Test;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.javautil.DefaultComparator;


public class RandomizedQuickSortTest {

	@Test
	public void test() {
		MutableArray<Integer> a = MutableArrayFromValues.create(3, 1, 2);
		RandomizedQuickSort.getInstance().sort(a, new DefaultComparator<Integer>());
	}

}
