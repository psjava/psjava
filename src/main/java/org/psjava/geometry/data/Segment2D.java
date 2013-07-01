package org.psjava.geometry.data;

import org.psjava.javautil.EqualityTester;
import org.psjava.javautil.StrictEqualityTester;

public class Segment2D<T> implements EqualityTester<Segment2D<T>> {

	public static <T> Segment2D<T> create(Point2D<T> p1, Point2D<T> p2) {
		return new Segment2D<T>(p1, p2);
	}

	private final Point2D<T> p1;
	private final Point2D<T> p2;

	private Segment2D(Point2D<T> p1, Point2D<T> p2) {
		if (p1.equals(p2))
			throw new IllegalArgumentException("Segment : two points are same");
		this.p1 = p1;
		this.p2 = p2;
	}

	public String toString() {
		return "Segment(" + p1 + "-" + p2 + ")";
	}

	public Point2D<T> p1() {
		return p1;
	}

	public Point2D<T> p2() {
		return p2;
	}

	public final boolean equals(Object obj) {
		return StrictEqualityTester.areEqual(this, obj, this);
	}

	@Override
	public boolean areEqual(Segment2D<T> o1, Segment2D<T> o2) {
		return (o2.p1.equals(o1.p1) && o2.p2.equals(o1.p2)) || (o2.p1.equals(o1.p2) && o2.p2.equals(o1.p1));
	}

	public final int hashCode() {
		return p1.hashCode() ^ p2.hashCode();
	}

}
