package org.psjava.algo.sort;


import org.junit.Test;


public class BubbleSortTest {
	@Test
	public void test() {
		SortTestUtil.testSimpleSort(BubbleSort.getInstance());
	}
}
