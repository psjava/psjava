package org.psjava.algo.sort;

import org.junit.Test;
import org.psjava.ds.array.MutableArray;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.javautil.DefaultComparator;


public class QuickSortTest {

	@Test
	public void test() {
		MutableArray<Integer> a = MutableArrayFromValues.create(3, 1, 2);
		new QuickSort().sort(a, new DefaultComparator<Integer>());
	}

}
