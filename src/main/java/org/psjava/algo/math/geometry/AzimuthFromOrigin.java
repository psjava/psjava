package org.psjava.algo.math.geometry;

import org.psjava.ds.geometry.Azimuth;
import org.psjava.ds.geometry.Point2D;
import org.psjava.ds.numbersystrem.Float64;

public class AzimuthFromOrigin {

	public static Azimuth calc(Point2D<Float64> p) {
		return AzimuthFromPoint.calc(p, Float64PointOrigin.ORIGIN);
	}

}
