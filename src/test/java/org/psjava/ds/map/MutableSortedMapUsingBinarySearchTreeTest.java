package org.psjava.ds.map;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.map.MutableSortedMapUsingBinarySearchTree;
import org.psjava.util.DefaultComparator;

public class MutableSortedMapUsingBinarySearchTreeTest {
	@Test
	public void test() {
		MutableSortedMap<Integer, Integer> map = MutableSortedMapUsingBinarySearchTree.<Integer, Integer> create(new DefaultComparator<Integer>());
		map.put(1, 100);
		map.put(3, 300);
		map.put(2, 200);
		Assert.assertEquals("(1=100,2=200,3=300)", map.toString());
	}

}
