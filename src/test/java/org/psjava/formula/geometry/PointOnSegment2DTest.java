package org.psjava.formula.geometry;

import org.junit.Test;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Segment2D;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

import static org.junit.Assert.*;

public class PointOnSegment2DTest {

    public static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

    @Test
    public void test() {
        Segment2D<Integer> s = Segment2D.create(Point2D.create(0, 0), Point2D.create(10, 0));
        assertTrue(PointOnSegment2D.isOn(Point2D.create(0, 0), s, NS));
        assertTrue(PointOnSegment2D.isOn(Point2D.create(5, 0), s, NS));
        assertFalse(PointOnSegment2D.isOn(Point2D.create(11, 0), s, NS));
    }

}