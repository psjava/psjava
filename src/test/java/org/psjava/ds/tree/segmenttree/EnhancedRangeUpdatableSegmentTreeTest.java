package org.psjava.ds.tree.segmenttree;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.UniformArray;
import org.psjava.javautil.FromTo;

public class EnhancedRangeUpdatableSegmentTreeTest {

	private static final Random RANDOM = new Random();

	@Test
	public void testFeatureUsingNaiveMethod() {
		int n = 100;
		EnhancedRangeUpdatableSegmentTree<Integer, Integer> tree = createAddTree(n);
		int[] a = new int[n];
		for (int i = 0; i < 100; i++) {
			int s = RANDOM.nextInt(n);
			int e = RANDOM.nextInt(n - s) + s + 1;
			int v = RANDOM.nextInt(20);
			if (i % 2 == 0) {
				tree.updateRange(s, e, v);
				for (int j : FromTo.get(s, e))
					a[j] += v;
			} else {
				int sum = 0;
				for (int j : FromTo.get(s, e))
					sum += a[j];
				Assert.assertEquals(sum, (int) tree.queryRange(s, e));
			}
		}
	}

	@Test(timeout = 1000)
	public void testPerformance() {
		int n = 10000;
		EnhancedRangeUpdatableSegmentTree<Integer, Integer> tree = createAddTree(n);
		for (int i = 0; i < 10000; i++) {
			int s = RANDOM.nextInt(n);
			int e = RANDOM.nextInt(n - s) + s + 1;
			if (i % 2 == 0)
				tree.updateRange(s, e, RANDOM.nextInt(20));
			else
				tree.queryRange(s, e);
		}
	}

	private EnhancedRangeUpdatableSegmentTree<Integer, Integer> createAddTree(int n) {
		return new EnhancedRangeUpdatableSegmentTree<Integer, Integer>(UniformArray.create(0, n), new EnhancedRangeUpdatableSegmentTreeOperator<Integer, Integer>() {

			@Override
			public Integer mergeSingleValue(Integer v1, Integer v2) {
				return v1 + v2;
			}

			@Override
			public Integer mergeRangeValue(Integer oldRangeValue, int rangeSize, Integer updateData) {
				return oldRangeValue + rangeSize * updateData;
			}

			@Override
			public Integer mergeUpdateData(Integer oldValue, Integer newValue) {
				return oldValue + newValue;
			}
		});
	}

}
