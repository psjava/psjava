package org.psjava.ds.geometry;

import org.psjava.ds.array.Array;
import org.psjava.ds.array.MutableArrayFromIterable;
import org.psjava.util.EqualityTester;
import org.psjava.util.StrictEqualityTester;

public class Polygon2D<T> {

	public static <T> Polygon2D<T> create(Iterable<Point2D<T>> src) {
		return new Polygon2D<T>(src);
	}

	private final Array<Point2D<T>> points;

	private Polygon2D(Iterable<Point2D<T>> src) {
		points = MutableArrayFromIterable.create(src);
	}

	public Array<Point2D<T>> getPointsAsArray() {
		return points;
	}

	@Override
	public String toString() {
		return "Polygon2D(" + points + ")";
	}

}
