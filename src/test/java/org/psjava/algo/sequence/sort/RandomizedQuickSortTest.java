package org.psjava.algo.sequence.sort;

import org.junit.Test;
import org.psjava.algo.sequence.sort.RandomizedQuickSort;


public class RandomizedQuickSortTest {

	@Test
	public void test() {
		SortTestUtil.testSimpleSort(new RandomizedQuickSort());
	}

}
