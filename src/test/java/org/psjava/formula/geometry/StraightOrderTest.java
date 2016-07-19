package org.psjava.formula.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;


public class StraightOrderTest {

    @Test
    public void testTrue() {
        Point2D<Integer> p1 = toPoint(0, 0);
        Point2D<Integer> p2 = toPoint(1, 1);
        Point2D<Integer> p3 = toPoint(2, 2);
        Assert.assertTrue(StraightOrder.is(p1, p2, p3, IntegerNumberSystem.getInstance()));
    }

    @Test
    public void testOnALineButFalse() {
        Point2D<Integer> p1 = toPoint(0, 0);
        Point2D<Integer> p2 = toPoint(2, 2);
        Point2D<Integer> p3 = toPoint(1, 1);
        Assert.assertFalse(StraightOrder.is(p1, p2, p3, IntegerNumberSystem.getInstance()));
    }

    @Test
    public void testAbsolutelyFalseCase() {
        Point2D<Integer> p1 = toPoint(0, 0);
        Point2D<Integer> p2 = toPoint(2, 2);
        Point2D<Integer> p3 = toPoint(0, 2);
        Assert.assertFalse(StraightOrder.is(p1, p2, p3, IntegerNumberSystem.getInstance()));
    }

    private Point2D<Integer> toPoint(int x, int y) {
        return Point2D.create(x, y);
    }

}
