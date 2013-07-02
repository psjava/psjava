package org.psjava.geometry.calc;

import org.psjava.geometry.data.Point2D;
import org.psjava.math.ns.Float64;
import org.psjava.math.ns.Float64NumberSystem;

public class DistanceBetweenPoints {
	
	public static double calc(Point2D<Float64> p1, Point2D<Float64> p2) {
		Float64 sq = DistanceSquareBetweenPoints.calc(Float64NumberSystem.getInstance(), p1, p2);
		return Math.sqrt(sq.toPrimitive());
	}
}
