package org.psjava.javautil;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.javautil.ArrayIterable;

public class ArrayIterableTest {

	@Test
	public void testIterator() {
		Iterable<Integer> iterable = ArrayIterable.create(1,2,3);
		assertEquals(TestUtil.toArrayList(1,2,3), TestUtil.toArrayListFromIterable(iterable));
	}

}
