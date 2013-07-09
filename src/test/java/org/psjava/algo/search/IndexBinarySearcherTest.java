package org.psjava.algo.search;


import org.junit.Assert;
import org.junit.Test;
import org.psjava.math.ns.JavaIntegerNumberSystem;

public class IndexBinarySearcherTest {

	private static final JavaIntegerNumberSystem NS = JavaIntegerNumberSystem.getInstance();

	@Test
	public void test() {
		int actual = IndexBinarySearcher.searchFirstTrue(NS, new IndexBinarySearcherData<Integer>() {
			@Override
			public boolean get(Integer index) {
				return index >= 100;
			}			
		}, -10000, 10000).getIndex();
		Assert.assertEquals(100, actual);
	}
	
	@Test
	public void testNagativeCase() {
		int actual = IndexBinarySearcher.searchFirstTrue(NS, new IndexBinarySearcherData<Integer>() {
			@Override
			public boolean get(Integer index) {
				return index >= -1000;
			}			
		}, -10000, 10000).getIndex();
		Assert.assertEquals(-1000, actual);
	}
	
	@Test
	public void testNotFoundCase() {
		boolean actual = IndexBinarySearcher.searchFirstTrue(NS, new IndexBinarySearcherData<Integer>() {
			@Override
			public boolean get(Integer index) {
				return false;
			}			
		}, -10, 10).isExist();
		Assert.assertFalse(actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNotFoundCaseException() {
		IndexBinarySearcher.searchFirstTrue(NS, new IndexBinarySearcherData<Integer>() {
			@Override
			public boolean get(Integer index) {
				return false;
			}			
		}, -10, 10).getIndex();
	}
	
}
