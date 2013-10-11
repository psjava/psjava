package org.psjava.formula.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.TestUtil;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.Int32;
import org.psjava.ds.numbersystrem.Int32NumberSystem;
import org.psjava.formula.geometry.DirectionComparator;

public class DirectionComparatorTest {

	private static final Int32NumberSystem NS = new Int32NumberSystem();
	private static final Comparator<Point2D<Int32>> COMP = DirectionComparator.create(NS, toPoint(0, 0), toPoint(1, 0));

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		Point2D<Int32> p1 = toPoint(10, 0);
		Point2D<Int32> p2 = toPoint(-10, 0);
		Point2D<Int32> p3 = toPoint(0, 10);
		Point2D<Int32> p4 = toPoint(0, -10);
		ArrayList<Point2D<Int32>> list = TestUtil.toArrayList(p1, p2, p3, p4);
		Collections.sort(list, COMP);
		Assert.assertEquals(TestUtil.toArrayList(p1, p3, p2, p4), list);
	}

	private static Point2D<Int32> toPoint(int x, int y) {
		return Point2D.create(Int32.valueOf(x), Int32.valueOf(y));
	}
}
