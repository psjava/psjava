package org.psjava.goods;

import org.psjava.algo.sequence.sort.RandomizedQuickSort;
import org.psjava.algo.sequence.sort.Sort;

public class GoodSort {

	private static final Sort INSTANCE = new RandomizedQuickSort();

	public static Sort getInstance() {
		return INSTANCE;
	}
}
