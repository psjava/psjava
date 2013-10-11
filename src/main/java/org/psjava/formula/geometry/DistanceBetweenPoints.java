package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.Float64;
import org.psjava.ds.numbersystrem.Float64NumberSystem;

public class DistanceBetweenPoints {
	
	public static double calc(Point2D<Float64> p1, Point2D<Float64> p2) {
		Float64 sq = DistanceSquareBetweenPoints.calc(Float64NumberSystem.getInstance(), p1, p2);
		return Math.sqrt(sq.toPrimitive());
	}
}
