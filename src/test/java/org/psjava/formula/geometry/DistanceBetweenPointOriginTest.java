package org.psjava.formula.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.geometry.Point2D;

public class DistanceBetweenPointOriginTest {
    @Test
    public void testDistance() {
        Assert.assertEquals(5, DistanceBetweenPointOrigin.calc(Point2D.create(3.0, 4.0)), 1e-10);
    }

}
