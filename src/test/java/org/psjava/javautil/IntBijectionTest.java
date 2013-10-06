package org.psjava.javautil;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.set.SetFromVarargs;
import org.psjava.javautil.IntBijection;


public class IntBijectionTest {
	@Test
	public void test() {
		IntBijection<String> r = IntBijection.create(SetFromVarargs.create("A", "B", "C"));
		Assert.assertEquals(3, r.size());
		int v1 = r.toInt("A");
		int v2 = r.toInt("B");
		int v3 = r.toInt("C");
		Assert.assertTrue(v1 != v2 && v2 != v3 && v3 != v1);
		Assert.assertEquals("A", r.toObject(v1));
	}
}
