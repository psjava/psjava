package org.psjava.formula.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class PointByDirectionComparatorTest {

    private static final IntegerNumberSystem NS = IntegerNumberSystem.getInstance();
    private static final Comparator<Point2D<Integer>> COMP = PointByDirectionComparator.create(NS, toPoint(0, 0), toPoint(1, 0));

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        Point2D<Integer> p1 = toPoint(10, 0);
        Point2D<Integer> p2 = toPoint(-10, 0);
        Point2D<Integer> p3 = toPoint(0, 10);
        Point2D<Integer> p4 = toPoint(0, -10);
        ArrayList<Point2D<Integer>> list = TestUtil.toArrayList(p1, p2, p3, p4);
        Collections.sort(list, COMP);
        Assert.assertEquals(TestUtil.toArrayList(p1, p3, p2, p4), list);
    }

    private static Point2D<Integer> toPoint(int x, int y) {
        return Point2D.create(x, y);
    }
}
