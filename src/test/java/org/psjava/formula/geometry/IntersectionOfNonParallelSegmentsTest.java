package org.psjava.formula.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Segment2D;
import org.psjava.ds.numbersystrem.Float64;
import org.psjava.ds.numbersystrem.Float64NumberSystem;
import org.psjava.formula.geometry.IntersectionOfNonParallelSegments;


public class IntersectionOfNonParallelSegmentsTest {

	private static final Float64NumberSystem NS = Float64NumberSystem.getInstance();

	@Test
	public void test() {
		Segment2D<Float64> s1 = Segment2D.create(toPoint(1, 0), toPoint(1, 10));
		Segment2D<Float64> s2 = Segment2D.create(toPoint(0, 2), toPoint(10, 2));
		Point2D<Float64> r = IntersectionOfNonParallelSegments.calc(NS, s1, s2, null);
		Assert.assertEquals(1, r.x().toPrimitive(), 1e-10);
		Assert.assertEquals(2, r.y().toPrimitive(), 1e-10);
	}

	private Point2D<Float64> toPoint(int x, int y) {
		return Point2D.create(Float64.valueOf(x), Float64.valueOf(y));
	}

}
