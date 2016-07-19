package org.psjava.formula.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class LeftTurnTest {

    private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

    @Test
    public void test() {
        Assert.assertTrue(LeftTurn.is(toPoint(0, 0), toPoint(0, 10), toPoint(-10, 10), NS));
        Assert.assertFalse(LeftTurn.is(toPoint(0, 0), toPoint(0, 10), toPoint(10, 10), NS));
    }

    @Test
    public void testStraight() {
        Assert.assertFalse(LeftTurn.is(toPoint(0, 0), toPoint(0, 10), toPoint(0, 20), NS));
    }

    private static Point2D<Integer> toPoint(int v, int v1) {
        return Point2D.create(v, v1);
    }

}