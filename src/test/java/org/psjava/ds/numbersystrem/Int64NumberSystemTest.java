package org.psjava.ds.numbersystrem;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.Int64;
import org.psjava.ds.numbersystrem.Int64NumberSystem;


public class Int64NumberSystemTest {
	
	private static final Int64NumberSystem NS = new Int64NumberSystem();
	
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
