package org.psjava.geometry.calc;

import org.psjava.geometry.data.Point2D;
import org.psjava.math.ns.Float64;

public class DistanceBetweenPointOrigin {

	public static double calc(Point2D<Float64> p) {
		return DistanceBetweenPoints.calc(p, Float64PointOrigin.ORIGIN);
	}

}
