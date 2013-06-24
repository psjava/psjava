package org.psjava.math.ns;

import org.junit.Assert;
import org.junit.Test;


public class Int64Test {
	
	@Test
	public void testCastingWhenUsingCache() {
		Int64 actual = Int64.valueOf(Long.MAX_VALUE);
		Assert.assertEquals(Long.MAX_VALUE, actual.v);		
	}

}
