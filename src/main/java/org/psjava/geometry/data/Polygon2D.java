package org.psjava.geometry.data;

import org.psjava.ds.array.AddToLastAll;
import org.psjava.ds.array.DynamicArray;
import org.psjava.javautil.EqualityTester;
import org.psjava.javautil.StrictEqualityTester;

public class Polygon2D<T> implements EqualityTester<Polygon2D<T>> {
	
	public static <T> Polygon2D<T> create(Iterable<Point2D<T>> src) {
		return new Polygon2D<T>(src);
	}

	private final DynamicArray<Point2D<T>> points = DynamicArray.create();
	
	private Polygon2D(Iterable<Point2D<T>> src) {
		AddToLastAll.add(points, src);
	}

	public boolean equals(Object obj) {
		return StrictEqualityTester.areEqual(this, obj, this);
	}

	@Override
	public boolean areEqual(Polygon2D<T> o1, Polygon2D<T> o2) {
		return o1.points.equals(o2.points);
	}

	@Override
	public int hashCode() {
		return points.hashCode();
	}

	public int pointNumber() {
		return points.size();
	}
	
	public Point2D<T> get(int index) {
		return points.get(index);
	}
	
	public int size() {
		return points.size();
	}
	
	@Override
	public String toString() {
		return "Polygon" + points;
	}

}
