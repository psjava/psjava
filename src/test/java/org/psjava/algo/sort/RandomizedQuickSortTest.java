package org.psjava.algo.sort;

import org.junit.Test;


public class RandomizedQuickSortTest {

	@Test
	public void test() {
		Sort sort = RandomizedQuickSort.getInstance();
		SortTestUtil.testSimpleSort(sort);
	}

}
