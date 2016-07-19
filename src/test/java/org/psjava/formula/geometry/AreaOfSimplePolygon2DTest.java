package org.psjava.formula.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.ds.numbersystrem.DoubleNumberSystem;

public class AreaOfSimplePolygon2DTest {

    private static final DoubleNumberSystem NS = DoubleNumberSystem.getInstance();

    @Test
    public void testArea() {
        @SuppressWarnings("unchecked")
        Polygon2D<Double> p = Polygon2D.create(TestUtil.toArrayList(toPoint(1, 10), toPoint(1, 1), toPoint(10, 1), toPoint(10, 10)));
        double actual = AreaOfSimplePolygon2D.calc(NS, p);
        Assert.assertEquals(81, actual, 1e-10);
    }

    @Test
    public void testZeroArea() {
        @SuppressWarnings("unchecked")
        Polygon2D<Double> p = Polygon2D.create(TestUtil.toArrayList(toPoint(1, 10), toPoint(1, 1)));
        double actual = AreaOfSimplePolygon2D.calc(NS, p);
        Assert.assertEquals(0, actual, 1e-10);
    }

    private static Point2D<Double> toPoint(double x, double y) {
        return Point2D.create(x, y);
    }
}
