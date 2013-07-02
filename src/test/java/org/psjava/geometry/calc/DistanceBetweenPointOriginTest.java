package org.psjava.geometry.calc;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.geometry.data.Point2D;
import org.psjava.math.ns.Float64;

public class DistanceBetweenPointOriginTest {
	@Test
	public void testDistance() {
		Assert.assertEquals(5, DistanceBetweenPointOrigin.calc(topoint(3, 4)), 1e-10);
	}

	private Point2D<Float64> topoint(int x, int y) {
		Point2D<Float64> p = Point2D.create(Float64.valueOf(x), Float64.valueOf(y));
		return p;
	}
}
