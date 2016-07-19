package org.psjava.formula.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Segment2D;
import org.psjava.ds.numbersystrem.DoubleNumberSystem;

public class IntersectionOfNonParallelSegmentsTest {

    private static final DoubleNumberSystem NS = DoubleNumberSystem.getInstance();

    @Test
    public void test() {
        Segment2D<Double> s1 = Segment2D.create(toPoint(1, 0), toPoint(1, 10));
        Segment2D<Double> s2 = Segment2D.create(toPoint(0, 2), toPoint(10, 2));
        Point2D<Double> r = IntersectionOfNonParallelSegments.calc(NS, s1, s2, null);
        Assert.assertEquals(1, r.x(), 1e-10);
        Assert.assertEquals(2, r.y(), 1e-10);
    }

    private Point2D<Double> toPoint(double x, double y) {
        return Point2D.create(x, y);
    }

}
