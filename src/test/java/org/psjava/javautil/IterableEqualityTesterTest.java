package org.psjava.javautil;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.TestUtil;


public class IterableEqualityTesterTest {
	@Test
	public void test() {
		Assert.assertTrue(IterableEqualityTester.areEqual(TestUtil.toArrayList(1, 2, 3), TestUtil.toArrayList(1, 2, 3)));
		Assert.assertFalse(IterableEqualityTester.areEqual(TestUtil.toArrayList(1, 2, 3), TestUtil.toArrayList(1, 2)));
		Assert.assertFalse(IterableEqualityTester.areEqual(TestUtil.toArrayList(1, 3), TestUtil.toArrayList(1, 2)));
	}
}
