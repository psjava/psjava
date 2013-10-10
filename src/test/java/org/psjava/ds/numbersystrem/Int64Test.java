package org.psjava.ds.numbersystrem;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.Int64;


public class Int64Test {
	
	@Test
	public void testCastingWhenUsingCache() {
		Int64 actual = Int64.valueOf(Long.MAX_VALUE);
		Assert.assertEquals(Long.MAX_VALUE, actual.v);		
	}

}
