package org.psjava.ds.set;

import org.junit.Test;

import java.util.HashSet;

public class MutableSetUsingJavaSetTest {

	@Test(expected = RuntimeException.class)
	public void testRemoveNotExist() {
		MutableSetUsingJavaSet<Integer> set = new MutableSetUsingJavaSet<Integer>(new HashSet<Integer>());
		set.addIfAbsent(1);
		set.remove(2);
	}

}