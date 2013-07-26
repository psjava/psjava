package org.psjava.algo.sort;

import org.junit.Test;


public class InsertionSortTest {
	@Test
	public void test() {
		Sort sort = InsertionSort.getInstance();
		SortTestUtil.testSimpleSort(sort);
	}
}
