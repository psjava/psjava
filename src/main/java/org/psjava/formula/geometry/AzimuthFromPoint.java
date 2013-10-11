package org.psjava.formula.geometry;

import org.psjava.ds.geometry.Azimuth;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.Float64;

public class AzimuthFromPoint {

	public static Azimuth calc(Point2D<Float64> p, Point2D<Float64> ref) {
		double y = p.y().toPrimitive() - ref.y().toPrimitive();
		double x = p.x().toPrimitive() - ref.x().toPrimitive();
		if (x == 0 && y == 0)
			throw new IllegalArgumentException("same points");
		return Azimuth.create(Math.atan2(y, x));
	}

}
