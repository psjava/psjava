package org.psjava.algo.sort;

import org.junit.Test;

public class MergeSortTest {
	@Test
	public void test() {
		Sort sort = MergeSort.getInstance();
		SortTestUtil.testSimpleSort(sort);
	}
}
