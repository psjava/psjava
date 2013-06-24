package org.psjava.math.ns;

import org.junit.Assert;
import org.junit.Test;


public class Int64SystemTest {
	
	private static final Int64System NS = new Int64System();
	
	@Test
	public void testAdd() {
		Int64 actual = NS.add(Int64.valueOf(1), Int64.valueOf(2));
		Assert.assertEquals(3, actual.v);
	}

	@Test (expected=ArithmeticException.class)
	public void testAddOverflow() {
		NS.add(Int64.valueOf(Long.MAX_VALUE), Int64.valueOf(1));
	}
	
}
