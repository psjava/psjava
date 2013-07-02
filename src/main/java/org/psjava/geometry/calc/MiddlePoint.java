package org.psjava.geometry.calc;

import org.psjava.geometry.data.Point2D;
import org.psjava.math.MiddleValue;
import org.psjava.math.ns.MultipliableNumberSystem;

public class MiddlePoint {

	public static <T> Point2D<T> calc(MultipliableNumberSystem<T> ns, Point2D<T> p1, Point2D<T> p2, T rateOf2) {
		T x = MiddleValue.calc(ns, p1.x(), p2.x(), rateOf2);
		T y = MiddleValue.calc(ns, p1.y(), p2.y(), rateOf2);
		return Point2D.create(x, y);
	}

}
