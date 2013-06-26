package org.psjava.geometry.data;

import org.psjava.javautil.EqualityTester;
import org.psjava.javautil.StrictEqualityTester;

public class Point2D<T> implements EqualityTester<Point2D<T>> {

	public static <T> Point2D<T> create(T x, T y) {
		return new Point2D<T>(x, y); 
	}
	
	private final T x;
	private final T y;
	
	private Point2D(T x, T y) {
		this.x = x;
		this.y = y;
	}

	public T x() {
		return x;
	}
	
	public T y() {
		return y;
	}

	@Override
	public final boolean equals(Object o) {
		return StrictEqualityTester.areEqual(this, o, this);
	}

	@Override
	public boolean areEqual(Point2D<T> o1, Point2D<T> o2) {
		return o1.x.equals(o2.x) && o1.y.equals(o2.y);
	}

	public final int hashCode() {
		return x.hashCode() ^ y.hashCode();
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
}
