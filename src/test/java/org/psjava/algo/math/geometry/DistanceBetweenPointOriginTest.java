package org.psjava.algo.math.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.math.geometry.DistanceBetweenPointOrigin;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.Float64;

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
