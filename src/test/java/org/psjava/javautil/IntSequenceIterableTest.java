package org.psjava.javautil;

import static org.junit.Assert.*;


import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.javautil.IntSequenceIterable;

public class IntSequenceIterableTest {

	@Test
	public void testIntSequenceIterable() {
		assertEquals(TestUtil.toArrayList(4, 6, 8), TestUtil.toArrayListFromIterable(IntSequenceIterable.create(4, 2, 3)));
		assertEquals(TestUtil.toArrayList(), TestUtil.toArrayListFromIterable(IntSequenceIterable.create(4, 1, 0)));
	}

}
