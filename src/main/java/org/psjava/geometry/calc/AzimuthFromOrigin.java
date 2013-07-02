package org.psjava.geometry.calc;

import org.psjava.geometry.data.Azimuth;
import org.psjava.geometry.data.Point2D;
import org.psjava.math.ns.Float64;

public class AzimuthFromOrigin {

	public static Azimuth calc(Point2D<Float64> p) {
		return AzimuthFromPoint.calc(p, Float64PointOrigin.ORIGIN);
	}

}
