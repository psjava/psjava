package org.psjava.algo.math.geometry;

import java.util.Comparator;

import org.psjava.algo.math.InRange;
import org.psjava.algo.math.Max;
import org.psjava.algo.math.Min;
import org.psjava.ds.geometry.Point2D;

public class PointOnFilledRectangle {

	public static <T> boolean isOn(Point2D<T> p, T x1, T x2, T y1, T y2, Comparator<T> comp) {
		T maxx = Max.max(x1, x2, comp);
		T minx = Min.min(x1, x2, comp);
		T maxy = Max.max(y1, y2, comp);
		T miny = Min.min(y1, y2, comp);
		return InRange.is(p.x(), minx, maxx, comp) && InRange.is(p.y(), miny, maxy, comp);
	}

}
