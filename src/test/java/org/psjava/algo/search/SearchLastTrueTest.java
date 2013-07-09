package org.psjava.algo.search;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.math.ns.JavaIntegerNumberSystem;


public class SearchLastTrueTest {

	@Test
	public void test() {
		int index = SearchLastTrue.search(JavaIntegerNumberSystem.getInstance(), -10000, 10000, new IndexBinarySearcherData<Integer>() {
			@Override
			public boolean get(Integer index) {
				return index <= 400;
			}
		}).getIndex();
		Assert.assertEquals(400, index);
	}

}
