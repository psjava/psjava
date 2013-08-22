package org.psjava.goods;

import org.psjava.algo.sort.RandomizedQuickSort;
import org.psjava.algo.sort.Sort;

public class GoodSort {

	private static final Sort INSTANCE = new RandomizedQuickSort();

	public static Sort getInstance() {
		return INSTANCE;
	}
}
