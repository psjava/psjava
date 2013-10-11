package org.psjava.formula.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.geometry.Azimuth;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.Float64;
import org.psjava.formula.geometry.AzimuthFromPoint;


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
