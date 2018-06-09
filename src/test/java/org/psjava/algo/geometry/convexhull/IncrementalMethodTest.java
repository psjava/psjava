package org.psjava.algo.geometry.convexhull;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.SetFromVarargs;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodSortingAlgorithm;

import java.util.Set;

public class IncrementalMethodTest extends ConvexHullAlgorithmTestBase {

    @Override
    protected ConvexHullAlgorithm getAlgorithm() {
        return IncrementalMethod.getInstance(GoodSortingAlgorithm.getInstance());
    }

    @Test
    public void testEdgeCase() {
        Set<Point2D<Integer>> points = SetFromVarargs.create(toPoint(0, 0), toPoint(0, 1), toPoint(0, 2), toPoint(10, 2), toPoint(10, 1), toPoint(10, 0));
        PSArray<Point2D<Integer>> hull = getAlgorithm().calc(points, IntegerNumberSystem.getInstance()).getCCWOrderPoints();
        Assert.assertEquals("((10,0),(10,2),(0,2),(0,0))", hull.toString());
    }

    private Point2D<Integer> toPoint(int x, int y) {
        return Point2D.create(x, y);
    }

}
