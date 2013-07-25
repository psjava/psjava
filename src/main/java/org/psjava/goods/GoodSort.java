package org.psjava.goods;

import org.psjava.algo.sort.RandomizedQuickSort;
import org.psjava.algo.sort.Sort;

public class GoodSort {
	public static Sort getInstance() {
		return RandomizedQuickSort.getInstance();
	}
}
