package org.psjava.formula.geometry;

import org.junit.Test;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Polygon2D;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.util.VarargsIterable;

import static org.junit.Assert.*;

public class PointOnPolygon2DTest {

    public static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

    @Test
    public void testOnePointPolygon() {
        Iterable<Point2D<Integer>> points = VarargsIterable.create(Point2D.create(0, 0));
        Polygon2D<Integer> poly = Polygon2D.create(points);
        assertTrue(PointOnPolygon2D.isOn(Point2D.create(0, 0), poly, NS));
        assertFalse(PointOnPolygon2D.isOn(Point2D.create(1, 1), poly, NS));
    }

}