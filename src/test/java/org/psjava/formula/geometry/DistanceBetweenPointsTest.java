package org.psjava.formula.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.Float64;
import org.psjava.formula.geometry.DistanceBetweenPoints;

public class DistanceBetweenPointsTest {

	@Test
	public void testDistanceZero() {
		Assert.assertEquals(0, DistanceBetweenPoints.calc(toPoint(0, 10), toPoint(0, 10)), 1e-10);
	}

	@Test
	public void testNormalDistance() {
		Assert.assertEquals(10, DistanceBetweenPoints.calc(toPoint(0, 10), toPoint(10, 10)), 1e-10);
		Assert.assertEquals(5, DistanceBetweenPoints.calc(toPoint(0, 10), toPoint(3, 14)), 1e-10);
	}

	private Point2D<Float64> toPoint(int x, int y) {
		return Point2D.create(Float64.valueOf(x), Float64.valueOf(y));
	}

}
