package org.psjava.geometry.calc;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.geometry.data.Azimuth;
import org.psjava.geometry.data.Point2D;
import org.psjava.math.ns.Float64;


public class AzimuthFromPointTest {
	@Test
	public void test() {
		Point2D<Float64> p = toPoint(2, Math.sqrt(3));
		Point2D<Float64> ref = toPoint(1, 0);
		Azimuth actual = AzimuthFromPoint.calc(p, ref);
		Assert.assertEquals(Math.toRadians(60), actual.radian(), 1e-10); // 60 degree
	}

	private Point2D<Float64> toPoint(double x, double y) {
		return Point2D.create(Float64.valueOf(x), Float64.valueOf(y));
	}
}
