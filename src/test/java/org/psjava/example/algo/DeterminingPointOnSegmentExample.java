package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.geometry.Segment2D;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.formula.geometry.PointOnSegment2D;

/**
 * @implementation {@link PointOnSegment2D}
 */
public class DeterminingPointOnSegmentExample {

    @Test
    public void example() {
        Point2D<Integer> point = Point2D.create(5, 0);
        Segment2D<Integer> segment = Segment2D.create(Point2D.create(0, 0), Point2D.create(10, 0));
        boolean on = PointOnSegment2D.isOn(point, segment, IntegerNumberSystem.getInstance()); // Must be true
        Assert.assertTrue(on);
    }


}
