package org.psjava.geometry.calc;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.geometry.data.Point2D;
import org.psjava.geometry.data.Polygon2D;
import org.psjava.math.ns.Float64;
import org.psjava.math.ns.Float64NumberSystem;

public class AreaOfSimplePolygon2DTest {

	private static final Float64NumberSystem NS = new Float64NumberSystem();

	@Test
	public void testArea() {
		@SuppressWarnings("unchecked")
		Polygon2D<Float64> p = toPoly(TestUtil.toArrayList(toPt(1, 10), toPt(1, 1), toPt(10, 1), toPt(10, 10)));
		Float64 actual = AreaOfSimplePolygon2D.calc(NS, p);
		Assert.assertEquals(81, actual.toPrimitive(), 1e-10);
	}

	@Test
	public void testZeroArea() {
		@SuppressWarnings("unchecked")
		Polygon2D<Float64> p = toPoly(TestUtil.toArrayList(toPt(1, 10), toPt(1, 1)));
		Float64 actual = AreaOfSimplePolygon2D.calc(NS, p);
		Assert.assertEquals(0, actual.toPrimitive(), 1e-10);
	}

	private static Polygon2D<Float64> toPoly(ArrayList<Point2D<Float64>> list) {
		return Polygon2D.create(list);
	}

	private static Point2D<Float64> toPt(double x, double y) {
		return Point2D.create(Float64.valueOf(x), Float64.valueOf(y));
	}
}
