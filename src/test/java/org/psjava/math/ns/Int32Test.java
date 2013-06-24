package org.psjava.math.ns;


import org.junit.Assert;
import org.junit.Test;

public class Int32Test {

	@Test
	public void testValueOf() throws Exception {
		Assert.assertEquals(1, Int32.valueOf(1).v);
		Assert.assertEquals(Integer.MAX_VALUE, Int32.valueOf(Integer.MAX_VALUE).v);
	}
}
	
