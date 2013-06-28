package org.psjava.math.ns;

import org.junit.Assert;
import org.junit.Test;


public class Float64NumberSystemTest {
	private static final Float64NumberSystem NS = Float64NumberSystem.getInstance();

	@Test
	public void test() {
		Assert.assertEquals(Float64.valueOf(3), NS.add(Float64.valueOf(1), Float64.valueOf(2)));
		Assert.assertEquals(Float64.valueOf(Double.POSITIVE_INFINITY), NS.divide(Float64.valueOf(1), Float64.valueOf(0)));
	}
}
